package modelo;

import java.io.Serializable;

public interface Entidade<T> extends Serializable {

    String getId();

    java.lang.String getNome();

}
