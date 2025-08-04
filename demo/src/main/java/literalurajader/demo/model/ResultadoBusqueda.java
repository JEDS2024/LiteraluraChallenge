package literalurajader.demo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultadoBusqueda {
    @JsonAlias("results")
    private List<Libro> resultados;

    public ResultadoBusqueda() {
    }

    public ResultadoBusqueda(List<Libro> resultados) {
        this.resultados = resultados;
    }

    public List<Libro> getResultados() {
        return resultados;
    }

    public void setResultados(List<Libro> resultados) {
        this.resultados = resultados;
    }
}
