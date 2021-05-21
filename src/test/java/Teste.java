import com.fatec.scel.model.Biblioteca;
import com.fatec.scel.model.Livro;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Teste {

	@Test
	public void ct01CadastroComSucesso() {
		// dado que nao existem livros cadastrados
		Biblioteca biblioteca = new Biblioteca();
		// quando um livro não existe cadastro
		Livro livro1 = new Livro();
		livro1.setAutor("Thiago Leite e Carvalho");
		;
		livro1.setIsbn("1000");
		livro1.setTitulo("Orientação a Objetos");
		biblioteca.save(livro1);
		// total de livros cadastrados igual 1
		assertEquals(1, biblioteca.size());
	}
	
	@Test
    public void ct02CadastrarComIsbnJaCadastrado() {
        //dado que nao existem livros cadastrados
        Biblioteca biblioteca = new Biblioteca();
        //quando um livro não existe cadastro
        Livro livro1 = new Livro();
        livro1.setAutor("Thiago Leite e Carvalho");;
        livro1.setIsbn("1000");
        livro1.setTitulo("Orientação a Objetos");
        biblioteca.save(livro1);
        //e outro livro com o mesmo isbn não cadastrado
        Livro livro2 = new Livro();
        livro2.setAutor("Thiago Leite e Carvalho");;
        livro2.setIsbn("1000");
        livro2.setTitulo("Orientação a Objetos");
        biblioteca.save(livro2);
        //total de livros cadastrados deve ser igual 1
        assertEquals(1, biblioteca.size());
    }
	@Test
    public void ct03CadastrarAutorEmBranco() {
        //dado que nao existem livros cadastrados
        Biblioteca biblioteca = new Biblioteca();
        //quando um livro  cadastrado com isbn em branco
        Livro livro1 = new Livro();
        livro1.setAutor("Thiago Leite e Carvalho");;
        livro1.setIsbn("");
        livro1.setTitulo("Orientação a Objetos");
        biblioteca.save(livro1);
        //total de livros cadastrados deve ser igual 0
        assertEquals(0, biblioteca.size());
    }

}
