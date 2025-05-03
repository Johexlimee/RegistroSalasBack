package co.edu.ue.utils;

public class Tools {
    // Clave secreta utilizada para la firma de los tokens JWT
    public static final String CLAVE = "c3VwZXJzZWNyZXRhZGVzdGluYWRvZGVtYXlsb2dhc2llYXBpZG9z"; 

    // Encabezado de la petición HTTP donde se espera encontrar el token JWT
    public static final String ENCABEZADO = "Authorization";
    
    // Prefijo que se agrega al token en el encabezado (por ejemplo: "Bearer <token>")
    public static final String PREFIJO_TOKEN = "Bearer ";
}
