
package conexionjavamongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject documento = new BasicDBObject();
    
    public Conexion(){
        try{
            Mongo mongo = new Mongo("localhost",27017);
            BaseDatos = mongo.getDB("Actividad502");
            coleccion = BaseDatos.getCollection("Actividad502");
            System.out.println("Conexión Exitosa");
        } catch(UnknownHostException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    //C-"CREATE", R-"READ", U-"UPDATE", D-"DELETE"
    //C-"CREATE"
    public boolean insert(String accion) {
        documento.put("accion", accion);
        coleccion.insert(documento);
        return true;
    }
    
    //R-"READ"
    public void getAll(){
        DBCursor cursor = coleccion.find();
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }
    
    //U-"UPDATE"
    public boolean update(String accionVieja, String accionNueva){
        documento.put("accion", accionVieja);
        BasicDBObject documentoNuevo = new BasicDBObject();
        documentoNuevo.put("accion", accionNueva);
        coleccion.findAndModify(documento, documentoNuevo);
        return true;
    }
    
    //D-"DELETE"
    public boolean delete(String accion){
        documento.put("accion", accion);
        coleccion.remove(documento);
        return true;
    }
    
}
