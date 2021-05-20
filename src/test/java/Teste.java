import com.fatec.scel.model.Biblioteca;
import com.fatec.scel.model.Livro;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Teste {

    @Test
    public void ct01_quando_dados_validos_cadastra_com_sucesso() {
        //dado que nao existem livros cadastrados
        Biblioteca biblioteca = new Biblioteca();
        //quando um livro é cadastrado
        Livro umLivro = new Livro();
        umLivro.setAutor("Pressman");;
        umLivro.setIsbn("1111");
        umLivro.setTitulo("Engenharia de Software");
        biblioteca.save(umLivro);
        //entao o total de livros cadastrados igual 1
        assertEquals(1, biblioteca.size());
    }

    @Test
    public void ct02_quando_cadastrar_livro_com_isbn_ja_cadastrado_nao_deve_cadastrar() {
        //dado que nao existem livros cadastrados
        Biblioteca biblioteca = new Biblioteca();
        //quando um livro é cadastrado
        Livro umLivro = new Livro();
        umLivro.setAutor("Pressman");;
        umLivro.setIsbn("1111");
        umLivro.setTitulo("Engenharia de Software");
        biblioteca.save(umLivro);
        //e outro livro com o mesmo isbn é cadastrado
        Livro outroLivro = new Livro();
        outroLivro.setAutor("Pressman");;
        outroLivro.setIsbn("1111");
        outroLivro.setTitulo("Engenharia de Software");
        biblioteca.save(outroLivro);
        //entao o total de livros cadastrados deve ser igual 1
        assertEquals(1, biblioteca.size());
    }

    @Test
    public void ct03_quando_cadastrar_livro_com_isbn_em_branco_nao_deve_cadastrar() {
        //dado que nao existem livros cadastrados
        Biblioteca biblioteca = new Biblioteca();
        //quando um livro é cadastrado com isbn em branco
        Livro umLivro = new Livro();
        umLivro.setAutor("Pressman");;
        umLivro.setIsbn("");
        umLivro.setTitulo("Engenharia de Software");
        System.out.println(umLivro);
        biblioteca.save(umLivro);
        //entao o total de livros cadastrados deve ser igual 0
        assertEquals(0, biblioteca.size());
    }

    @Test
    public void ct04_quando_cadastrar_livro_com_titulo_em_branco_nao_deve_cadastrar() {
        //dado que nao existem livros cadastrados
        Biblioteca biblioteca = new Biblioteca();
        //quando um livro é cadastrado com isbn em branco
        Livro umLivro = new Livro();
        umLivro.setAutor("Pressman");;
        umLivro.setIsbn("1111");
        umLivro.setTitulo("");
        System.out.println(umLivro);
        biblioteca.save(umLivro);
        //entao o total de livros cadastrados deve ser igual 0
        assertEquals(0, biblioteca.size());
    }
}
