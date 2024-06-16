import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarefa {
    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao;

    public Tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = LocalDateTime.now();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDataCriacaoFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dataCriacao.format(formatter);
    }

    @Override
    public String toString() {
        return "Tarefa: " +
               "\n- Título: " + titulo +
               "\n- Descrição: " + descricao +
               "\n- Data de Criação: " + getDataCriacaoFormatada() + "\n";
    }
}
