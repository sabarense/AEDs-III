package TP01;

import java.io.File;

public class Principal {

    public static void main(String args[]) {
        File file = new File("TP01/filmes.db");
        file.delete();

        Arquivo<Filme> arquivoFilmes;
        Filme livro1 = new Filme(-1, "Barbie", 10, "Cristina", 4.30);
        Filme livro2 = new Filme(-1, "Harry Potter", 11, "Joana", 6.00);
        Filme livro3 = new Filme(-1, "Borboletas", 29, "Juliano", 2.15);
        Filme livro4 = new Filme(-1, "Homem Aranha", 5, "Marvel", 8.30);
        Filme livro5 = new Filme(-1, "Interestrel", 1, "Viajantes", 7.50);
        Filme livro6 = new Filme(-1, "Enrolados", 19, "Disney", 8.84);
        int idLivro1, idLivro2, idLivro3, idLivro4, idLivro5, idLivro6;

        try {
            arquivoFilmes = new Arquivo<>("TP01/filmes.db", Filme.class.getConstructor());

            //CREATE

            // Seção: Criação de Filme 1
            idLivro1 = arquivoFilmes.create(livro1);
            System.out.println("Filme criado com o ID: " + idLivro1 + " e o nome: " + livro1.getNome());

            // Seção: Criação de Filme 2
            idLivro2 = arquivoFilmes.create(livro2);
            System.out.println("Filme criado com o ID: " + idLivro2 + " e o nome: " + livro2.getNome());

            // Seção: Criação de Filme 3
            idLivro3 = arquivoFilmes.create(livro3);
            System.out.println("Filme criado com o ID: " + idLivro3 + " e o nome: " + livro3.getNome());

            // Seção: Criação de Filme 4
            idLivro4 = arquivoFilmes.create(livro4);
            System.out.println("Filme criado com o ID: " + idLivro4 + " e o nome: " + livro4.getNome());

            // Seção: Criação de Filme 5
            idLivro5 = arquivoFilmes.create(livro5);
            System.out.println("Filme criado com o ID: " + idLivro5 + " e o nome: " + livro5.getNome());

            // Seção: Criação de Filme 6
            idLivro6 = arquivoFilmes.create(livro6);
            System.out.println("Filme criado com o ID: " + idLivro6 + " e o nome: " + livro6.getNome());

            //READ

            // Seção: Leitura e Verificação de Livro 1
            if ((livro1 = arquivoFilmes.read(idLivro1)) != null)
                System.out.println("Filme encontrado: " + livro1.getNome());
            else
                System.out.println("Filme de ID " + idLivro1 + " não encontrado!");

            // Seção: Leitura e Verificação de Livro 2
            if ((livro2 = arquivoFilmes.read(idLivro2)) != null)
                System.out.println("Filme encontrado: " + livro2.getNome());
            else
                System.out.println("Filme de ID " + idLivro2 + " não encontrado!");

            // Seção: Leitura e Verificação de Livro 3
            if ((livro3 = arquivoFilmes.read(idLivro3)) != null)
                System.out.println("Filme encontrado: " + livro3.getNome());
            else
                System.out.println("Filme de ID " + idLivro3 + " não encontrado!");

            // Seção: Leitura e Verificação de Livro 4
            if ((livro4 = arquivoFilmes.read(idLivro4)) != null)
                System.out.println("Filme encontrado: " + livro4.getNome());
            else
                System.out.println("Filme de ID " + idLivro4 + " não encontrado!");

            // Seção: Leitura e Verificação de Livro 5
            if ((livro5 = arquivoFilmes.read(idLivro5)) != null)
                System.out.println("Filme encontrado: " + livro5.getNome());
            else
                System.out.println("Filme de ID " + idLivro5 + " não encontrado!");

            // Seção: Leitura e Verificação de Livro 6
            if ((livro6 = arquivoFilmes.read(idLivro6)) != null)
                System.out.println("Filme encontrado: " + livro6.getNome());
            else
                System.out.println("Filme de ID " + idLivro6 + " não encontrado!");


            //DELETE

            // Seção: Exclusão de Filme 1
            if (arquivoFilmes.delete(livro1.getId()))
                System.out.println("Filme de ID " + idLivro1 + " excluído!");
            else
                System.out.println("Filme de ID " + idLivro1 + " não foi possível excluir!");

            // Seção: Exclusão de Filme 2
            if (arquivoFilmes.delete(livro2.getId()))
                System.out.println("Filme de ID " + idLivro2 + " excluído!");
            else
                System.out.println("Filme de ID " + idLivro2 + " não foi possível excluir!");

            // Seção: Exclusão de Filme 3
            if (arquivoFilmes.delete(livro3.getId()))
                System.out.println("Filme de ID " + idLivro3 + " excluído!");
            else
                System.out.println("Filme de ID " + idLivro3 + " não foi possível excluir!");

            // Seção: Exclusão de Livro 4
            if (arquivoFilmes.delete(livro4.getId()))
                System.out.println("Filme de ID " + idLivro4 + " excluído!");
            else
                System.out.println("Filme de ID " + idLivro4 + " não foi possível excluir!");

            // Seção: Exclusão de Livro 5
            if (arquivoFilmes.delete(livro5.getId()))
                System.out.println("Filme de ID " + idLivro5 + " excluído!");
            else
                System.out.println("Filme de ID " + idLivro5 + " não foi possível excluir!");

            // Seção: Exclusão de Filme 6
            if (arquivoFilmes.delete(livro6.getId()))
                System.out.println("Filme de ID " + idLivro6 + " excluído!");
            else
                System.out.println("Filme de ID " + idLivro6 + " não foi possível excluir!");

            //UPDATE

            // Seção: Atualização de Livro 5
            //  livro5.setNome("Interestrelar");
            //   if (arquivoFilmes.update(livro5))
            //      System.out.println("Filme de ID " + livro5.getId() + " Nome: " +  livro5.getNome() + " alterado!");
            //  else
            //      System.out.println("Filme de ID " + livro5.getId() + " Nome: " +  livro5.getNome() + " não foi possível atualizar!");


            arquivoFilmes.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
