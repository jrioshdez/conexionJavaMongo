
package conexionjavamongo;

public class ConexionJavaMongo {

    public static void main(String[] args) {
        
        Conexion conec = new Conexion();
        //conec.insert("Nadar");
        conec.getAll();
        //conec.update("correr", "Brincar");
        //conec.getAll();
        conec.delete("Nadar");
        conec.getAll();
    }
    
}
