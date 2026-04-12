package modelo;

import java.sql.SQLException;

public interface Gestionable <T> {
    int guardar(T clase) throws SQLException;
}
