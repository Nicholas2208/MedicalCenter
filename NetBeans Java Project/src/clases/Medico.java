package clases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author OMG_DaNgErOuS_PablO_MLG
 */
public class Medico {

	private final int n_colegiado;
	private final Conexion con;
	private int n_especialidad;
	boolean[] dia1;
	boolean[] dia2;
	boolean[] dia3;
	boolean[] diaVacio;
	PreparedStatement preparedStmt = null;
	String fecha1;
	String fecha2;
	String fecha3;
	Calendar fecha = new GregorianCalendar();
	int horaI = 0;

	public Medico(int n_colegiado, Conexion con) throws SQLException {
		this.n_colegiado = n_colegiado;
		this.con = con;
		dia1 = new boolean[(240 / this.getTiempoMin())]; // 240 minutos de turno
		dia2 = new boolean[(240 / this.getTiempoMin())]; // entre el tiempo minimo
		dia3 = new boolean[(240 / this.getTiempoMin())]; // de atencion del medico
		diaVacio = new boolean[(240 / this.getTiempoMin())]; // Día libre sin 
		for (int i = 0; i < diaVacio.length; i++) {			// turnos ocupados
			diaVacio[i] = false;
		}

		fecha1 = fecha.get(Calendar.YEAR) + "-"
				+ (fecha.get(Calendar.MONTH) + 1) + "-"
				+ fecha.get(Calendar.DAY_OF_MONTH);

		fecha.add(Calendar.DAY_OF_MONTH, 1);
		fecha2 = fecha.get(Calendar.YEAR) + "-"
				+ (fecha.get(Calendar.MONTH) + 1) + "-"
				+ fecha.get(Calendar.DAY_OF_MONTH);

		fecha.add(Calendar.DAY_OF_MONTH, 1);
		fecha3 = fecha.get(Calendar.YEAR) + "-"
				+ (fecha.get(Calendar.MONTH) + 1) + "-"
				+ fecha.get(Calendar.DAY_OF_MONTH);

		if ("Mañana".equals(this.getTurno())) {
			horaI = 9;
		} else if ("Tarde".equals(this.getTurno())) {
			horaI = 15;
		}
		Connection reg = con.getCon();
		String sql = "SELECT hora FROM centromedico.citas WHERE medico=? AND dia =?;";
		preparedStmt = reg.prepareStatement(sql);
		preparedStmt.setInt(1, n_colegiado);
		preparedStmt.setDate(2, java.sql.Date.valueOf(fecha1));
		ResultSet rs = preparedStmt.executeQuery();

		List<String> horas;
		horas = new ArrayList<>();
		while (rs.next()) {
			horas.add(rs.getTime("hora").toString());
		}
		for (int i = 0; i < dia1.length; i++) {
			dia1[i] = false;
		}
		for (int i = 0; i < horas.size(); i++) {
			String hora[] = horas.get(i).split(":");
			int horadiv = Integer.parseInt(hora[0]);
			int minutos = Integer.parseInt(hora[1]);
			int index = ((horadiv - horaI) * 60 + minutos) / this.getTiempoMin();
			dia1[index] = true;
		}
		horas.clear();

		preparedStmt = reg.prepareStatement(sql);
		preparedStmt.setInt(1, n_colegiado);
		preparedStmt.setDate(2, java.sql.Date.valueOf(fecha2));
		rs = preparedStmt.executeQuery();

		while (rs.next()) {
			horas.add(rs.getTime("hora").toString());
		}
		for (int i = 0; i < dia2.length; i++) {
			dia2[i] = false;
		}
		for (int i = 0; i < horas.size(); i++) {
			String hora[] = horas.get(i).split(":");
			int horadiv = Integer.parseInt(hora[0]);
			int minutos = Integer.parseInt(hora[1]);
			int index = ((horadiv - horaI) * 60 + minutos) / this.getTiempoMin();
			dia2[index] = true;
		}
		horas.clear();

		preparedStmt = reg.prepareStatement(sql);
		preparedStmt.setInt(1, n_colegiado);
		preparedStmt.setDate(2, java.sql.Date.valueOf(fecha3));
		rs = preparedStmt.executeQuery();

		while (rs.next()) {
			horas.add(rs.getTime("hora").toString());
		}
		for (int i = 0; i < dia3.length; i++) {
			dia3[i] = false;
		}
		for (int i = 0; i < horas.size(); i++) {
			String hora[] = horas.get(i).split(":");
			int horadiv = Integer.parseInt(hora[0]);
			int minutos = Integer.parseInt(hora[1]);
			int index = ((horadiv - horaI) * 60 + minutos) / this.getTiempoMin();
			dia3[index] = true;
		}
		horas.clear();
		setNumEspecialidad();
	}

	public int getTiempoMin() throws SQLException {
		int result = 0;
		Connection reg = con.getCon();
		String sql = "SELECT tiempo_min FROM centromedico.medico WHERE N_colegiado=?;";
		preparedStmt = reg.prepareStatement(sql);
		preparedStmt.setInt(1, n_colegiado);
		ResultSet rs = preparedStmt.executeQuery();
		if (rs.next()) {
			result = rs.getInt("tiempo_min");
		}
		return result;
	}

	public String getTurno() throws SQLException {
		String result = null;
		Connection reg = con.getCon();
		String sql = "SELECT horario FROM centromedico.medico WHERE N_colegiado=?;";
		preparedStmt = reg.prepareStatement(sql);
		preparedStmt.setInt(1, n_colegiado);
		ResultSet rs = preparedStmt.executeQuery();
		if (rs.next()) {
			result = rs.getString("horario");
		}
		return result;
	}

	public String getNombre() throws SQLException {
		String result = null;
		Connection reg = con.getCon();
		String sql = "SELECT nombre, apellidos FROM centromedico.medico WHERE N_colegiado=?";
		preparedStmt = reg.prepareStatement(sql);
		preparedStmt.setInt(1, n_colegiado);
		ResultSet rs = preparedStmt.executeQuery();
		if (rs.next()) {
			result = rs.getString("nombre") + " " + rs.getString("apellidos");
		}
		return result;
	}

	public String getEspecialidad() throws SQLException {
		String result = null;
		Connection reg = con.getCon();
		String sql = "SELECT especialidad.nombre FROM centromedico.especialidad WHERE cod_especialidad=?;";
		preparedStmt = reg.prepareStatement(sql);
		preparedStmt.setInt(1, getN_Especialidad());
		ResultSet rs = preparedStmt.executeQuery();
		if (rs.next()) {
			result = rs.getString("especialidad.nombre");
		}
		return result;
	}

	private void setNumEspecialidad() throws SQLException {
		int result = 0;
		Connection reg = con.getCon();
		String sql = "SELECT medico.especialidad FROM centromedico.medico WHERE N_colegiado=? ;";
		preparedStmt = reg.prepareStatement(sql);
		preparedStmt.setInt(1, n_colegiado);
		ResultSet rs = preparedStmt.executeQuery();
		if (rs.next()) {
			result = rs.getInt("medico.especialidad");
		}
		this.n_especialidad = result;
	}

	public boolean codCitaEnBD(String codCita) throws SQLException {
		boolean result = true;
		PreparedStatement preparedStmt;
		Connection reg = con.getCon();
		String codCitaDB = null;
		String sql = "SELECT cod_cita FROM centromedico.citas WHERE cod_cita=? ;";
		preparedStmt = reg.prepareStatement(sql);
		preparedStmt.setString(1, codCita);
		ResultSet rs = preparedStmt.executeQuery();
		while (rs.next()) {
			codCitaDB = rs.getString("cod_cita");
		}
		if (codCitaDB == null) {
			result = false;
		}
		return result;
	}

	public void addCita(String hora, String fecha, String paciente, int contCitas) throws SQLException {
		String horas[] = hora.split(":");
		int codEsp = 0;
		int horadiv = Integer.parseInt(horas[0]);
		int minutos = Integer.parseInt(horas[1]);
		Connection reg = con.getCon();
		String sql = "SELECT especialidad FROM centromedico.medico WHERE N_colegiado=?;";
		preparedStmt = reg.prepareStatement(sql);
		preparedStmt.setInt(1, n_colegiado);
		ResultSet rs = preparedStmt.executeQuery();
		if (rs.next()) {
			codEsp = rs.getInt("especialidad");
		}
		sql = "INSERT INTO centromedico.citas ( cod_cita, dia, hora, medico, especialidad, paciente)"
				+ "VALUES (?,?,?,?,?,?)";
		preparedStmt = reg.prepareStatement(sql);
		String codcita = paciente + (contCitas + 1);
		while (codCitaEnBD(codcita)) {
			contCitas++;
			codcita = paciente + (contCitas + 1);
		}
		preparedStmt.setString(1, codcita);
		preparedStmt.setString(2, fecha);
		preparedStmt.setString(3, hora);
		preparedStmt.setInt(4, n_colegiado);
		preparedStmt.setInt(5, codEsp);
		preparedStmt.setString(6, paciente);
		preparedStmt.execute();

		int index = ((horadiv - horaI) * 60 + minutos) / this.getTiempoMin();
		boolean consultaFecha[] = getConsultas(fecha);
		consultaFecha[index] = false;
	}

	public void eliminarCita(String dia, String hora) throws SQLException {
		String horas[] = hora.split(":");
		int codEsp = 0;
		boolean consultaFecha[] = getConsultas(dia);
		int horadiv = Integer.parseInt(horas[0]);
		int minutos = Integer.parseInt(horas[1]);

		int index = ((horadiv - horaI) * 60 + minutos) / this.getTiempoMin();
		consultaFecha[index] = true;
	}

	/**
	 * Retorna los turnos disponibles para atender en ese día concreto.
	 *
	 * @param dia
	 * @return
	 * @throws SQLException
	 */
	public boolean[] getConsultas(String dia) throws SQLException {
		String fechas[] = dia.split("-");
		Date fechacita = new Date(Integer.parseInt(fechas[0]),
				Integer.parseInt(fechas[1]) - 1, Integer.parseInt(fechas[2]));
		String fechas1[] = fecha1.split("-");
		Date dia01 = new Date(Integer.parseInt(fechas1[0]),
				Integer.parseInt(fechas1[1]) - 1, Integer.parseInt(fechas1[2]));
		String fechas3[] = fecha3.split("-");
		Date dia03 = new Date(Integer.parseInt(fechas3[0]),
				Integer.parseInt(fechas3[1]) - 1, Integer.parseInt(fechas3[2]));
		if (fechacita.compareTo(dia01) < 0) {
			return diaVacio;
		} else if (dia.equals(fecha1)) {
			return dia1;
		} else if (dia.equals(fecha2)) {
			return dia2;
		} else if (dia.equals(fecha3)) {
			return dia3;
		} else if (fechacita.compareTo(dia03) > 0) {
			return diaVacio;
		}
		return null;
	}

	public int getNumCitasLibres(String dia) throws SQLException {
		int result = 0;
		boolean consultaFecha[] = getConsultas(dia);
		for (int i = 0; i < consultaFecha.length; i++) {
			if (consultaFecha[i] == true) {
				result++;
			}
		}
		return result;
	}

	public int getNumCitas() throws SQLException {
		int resul = 0;

		Connection reg = con.getCon();
		String sql = "SELECT COUNT(Cod_cita) FROM centromedico.citas WHERE medico=? ";
		preparedStmt = reg.prepareStatement(sql);
		preparedStmt.setInt(1, n_colegiado);
		ResultSet rs = preparedStmt.executeQuery();

		if (rs.next()) {
			resul = rs.getInt("COUNT(Cod_cita)");
		}
		return resul;
	}

	public int getN_Especialidad() throws SQLException {
		return this.n_especialidad;
	}

//        public String mostrarMedico() throws SQLException {
//        // Selecciona y muestra por pantalla los datos del medico con el parametro n_colegiado
//        Connection reg = con.getCon();
//        String sql;
//        int nColegiado = 0;
//        String nombre = "";
//        String apellidos = "";
//        String horario = "";
//        String tiempo = "";
//        String especialidades = "";
//        sql = "SELECT medico.n_colegiado, medico.nombre, medico.apellidos, medico.horario, medico.tiempo_min, medico.especialidad, especialidad.nombre "
//                + "FROM centromedico.medico, centromedico.especialidad "
//                + "WHERE medico.especialidad = especialidad.cod_especialidad "
//                + "and medico.n_colegiado = ?;";
//
//        preparedStmt = reg.prepareStatement(sql);
//        preparedStmt.setInt(1, this.getN_colegiado());
//        ResultSet rs = preparedStmt.executeQuery();
//
//       if (rs.next()) {
//            nColegiado = rs.getInt("medico.n_colegiado");
//            nombre = rs.getString("medico.nombre");
//            apellidos = rs.getString("medico.apellidos");
//            horario = rs.getString("medico.horario");
//            tiempo = rs.getString("medico.tiempo_min");
//            especialidades = rs.getString("especialidad.nombre");
//        }
//        return (nColegiado + " - " + nombre + " " + apellidos + "; " + tiempo + ", " + especialidades);
//    }
	/**
	 * Este método retorna un ResultSet de SQL de los pacientes asociados a ese
	 * médico Si no hay pacientes asociados, no retorna nada.
	 *
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet mostrarPacientesAsociados() throws SQLException {
		Connection reg = con.getCon();
		String sql;
		sql = "SELECT paciente.* FROM centromedico.paciente, centromedico.historial "
				+ "WHERE historial.especialidad = ?  AND historial.paciente = paciente.DNI "
				+ "GROUP BY historial.paciente";

		preparedStmt = reg.prepareStatement(sql);
		preparedStmt.setInt(1, getN_Especialidad());
		ResultSet rs = preparedStmt.executeQuery();

		return rs;
	}
	
	/**
	 * HOLA ALEEEX! 
	 * Devuelve el horario libre de citas del médico para la fecha, hora y 
	 * especialidad proporcionada.
	 * 
	 * @param fecha
	 * @param especialidad
	 * @param horario
	 * @return String[]
	 * @throws SQLException 
	 */
	public String[] getConsultasDisponibles(String fecha, String especialidad, 
			String horario) throws SQLException{
		int inicioHorario;
		// Preparamos consulta
		Connection reg = this.con.getCon();
		String sql;
		sql = "SELECT Hora FROM centromedico.citas WHERE Dia='" + fecha + 
			  "' ";	// Queremos los horarios de las citas del médico de ese dia
		if(horario.equals("Mañana")){ // Solo horarios de turno mañana
			sql += "AND Hora<'13:00:00' ";
			inicioHorario = 9;
		}else{		// Solo horarios de turno tarde
			sql += "AND Hora>='13:00:00' ";
			inicioHorario = 13;
		}
		sql += "AND Especialidad=(SELECT Cod_especialidad " + // y de esta 
			   "FROM centromedico.especialidad WHERE Nombre=?);"; // especialidad
		
		preparedStmt = reg.prepareStatement(sql);
		preparedStmt.setString(1, especialidad);
		ResultSet rs = preparedStmt.executeQuery();
		
		return this.construirHorario(rs, inicioHorario);
	}
	
	/**
	 * TODO
	 * Con el ResultSet obtenido devuelve un array de strings de horarios 
	 * libres del médico menos los ya ocupados señalados en el ResultSet.
	 * 
	 * @param rs
	 * @return String[]
	 */
	private String[] construirHorario(ResultSet rs, int horaInicio)
			throws SQLException{
		ArrayList<String> horariosOcupados = new ArrayList<>();
		String horaReserv;
		while(rs.next()){ // cargamos en el arraylist los horarios de citas ya 
			horaReserv = rs.getString("Hora"); // reservadas.
			horariosOcupados.add(horaReserv.substring(0, horaReserv.length()-3));
		}
		
		int minuto = 60, hora = horaInicio-1;
		int horaOcupada, minutoOcupado;
		ArrayList<String> horarioFinal = new ArrayList<>();
		for (int i = 0; i < 240/this.getTiempoMin(); i++) { // iteramos sobre el 
			if(minuto > 59){
				hora++; minuto = 0;
			}
			// cargamos de horariosOcupados sobre las variables hora y minuto ocupada
			// comprobamos si coincide con hora y minuto 
		}
		
		return null;
	}

	public ResultSet mostrarCitasMedico() throws SQLException {
		Connection reg = con.getCon();
		String sql;
		sql = "SELECT citas.cod_cita, citas.dia, citas.hora, citas.medico, "
				+ "especialidad.nombre as especialidad, citas.paciente "
				+ "FROM centromedico.citas, centromedico.especialidad "
				+ "WHERE citas.medico = ?  AND especialidad.cod_especialidad = citas.especialidad "
				+ "GROUP BY citas.paciente";

		preparedStmt = reg.prepareStatement(sql);
		preparedStmt.setInt(1, getN_colegiado());
		ResultSet rs = preparedStmt.executeQuery();

		return rs;
	}

	/**
	 * Retorna el ResultSet de solo citas que tiene hoy el médico para poder
	 * abrir una ficha de historial a un paciente de los presentes.
	 *
	 * @return
	 * @throws SQLException
	 */
	public ResultSet mostrarCitasHoyMedico() throws SQLException {
		Connection reg = con.getCon();
		String sql;
		sql = "SELECT citas.cod_cita, citas.paciente , citas.dia, citas.hora,"
				+ "citas.medico, especialidad.nombre as especialidad"
				+ "FROM centromedico.citas, centromedico.especialidad "
				+ "WHERE citas.medico = ?  AND "
				+ "especialidad.cod_especialidad = citas.especialidad AND "
				+ "citas.dia = ?"
				+ "GROUP BY citas.paciente";

		Calendar fecha = new GregorianCalendar();
		preparedStmt = reg.prepareStatement(sql);
		preparedStmt.setInt(1, getN_colegiado());
		preparedStmt.setDate(2, java.sql.Date.valueOf(getDia()));
		ResultSet rs = preparedStmt.executeQuery();

		return rs;
	}

	/**
	 * Método para invocar un historial y ficha de un paciente. DNIPACIENTE Y
	 * CODIGO DE CITA DEBEN COINCIDIR!
	 *
	 * @param DNIPaciente
	 * @param codCita
	 * @param comentario
	 * @throws SQLException
	 */
	public void escribirFichaPaciente(String DNIPaciente, String codCita,
			String comentario) throws SQLException {
		Historial historial = new Historial(DNIPaciente, this.n_especialidad,
				this.con, codCita, comentario);
	}

	/**
	 * Retorna un ResultSet con los historiales cuya especialidad coincide con
	 * la del médico en cuestión.
	 *
	 * @return
	 * @throws SQLException
	 */
	public ResultSet mostrarHistoriales() throws SQLException {
		Connection reg = con.getCon();
		String sql;
		sql = "SELECT * FROM centromedico.historial WHERE especialidad=?";

		preparedStmt = reg.prepareStatement(sql);
		preparedStmt.setInt(1, this.n_especialidad);
		ResultSet rs = preparedStmt.executeQuery();

		return rs;
	}

	/**
	 * Retorna un ResultSet para enseñar las fichas cuyo codigo de historial
	 * coincide con el proporcionado, DEBE COMPROBARSE QUE ESTE CÓDIGO PERTENECE
	 * EN EL SELECT PROPORCIONADO.
	 *
	 * @param codigoHistorial
	 * @return
	 * @throws SQLException
	 */
	public ResultSet mostrarFichas(int codigoHistorial) throws SQLException {
		Historial historial = new Historial(codigoHistorial, this.con);
		return historial.mostrarFichas(); //Que guapada eso de la POO eh?
	}

	/**
	 * Con el codigo del historial y el de cita se procede a modificar el
	 * comentario en la BD con el proporcionado. Además se actualizará la hora.
	 *
	 * @param codigoHistorial
	 * @param codigoCita
	 * @param comentario
	 * @throws SQLException
	 */
	public void modificarFicha(int codigoHistorial, String codigoCita,
			String comentario) throws SQLException {
		Historial historial = new Historial(codigoHistorial, this.con);
		historial.modificarFicha(codigoCita, comentario);
	}

	/**
	 * Retorna el día actual formato AAAA-MM-DD.
	 *
	 * @return
	 */
	private String getDia() {
		return fecha.get(Calendar.YEAR) + "-"
				+ (fecha.get(Calendar.MONTH) + 1) + "-"
				+ fecha.get(Calendar.DAY_OF_MONTH);
	}

	public int getN_colegiado() {
		return n_colegiado;
	}
}
