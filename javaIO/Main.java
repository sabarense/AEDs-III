package javaIO;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        byte[] byteArray;

        try {
            /* WRITE */
            Livro livro1 = new Livro(1, "Eu, Robô", "Isaac Asimov", 14.9F);
            Livro livro2 = new Livro(2, "Eu sou A Lenda", "Richard Matheson", 21.99F);

            try (FileOutputStream file = new FileOutputStream("javaIO/dados/livros.db");
                 DataOutputStream dataOutputStream = new DataOutputStream(file)) {

                // livro1
                byteArray = livro1.toByteArray();
                dataOutputStream.writeInt(byteArray.length);
                dataOutputStream.write(byteArray);

                // livro2
                byteArray = livro2.toByteArray();
                dataOutputStream.writeInt(byteArray.length);
                dataOutputStream.write(byteArray);

            }

            /* READ */
            Livro livro3 = new Livro();
            Livro livro4 = new Livro();
            int tam;

            try (FileInputStream file = new FileInputStream("javaIO/dados/livros.db");
                 DataInputStream dataInputStream = new DataInputStream(file)) {

                // livro3
                tam = dataInputStream.readInt();
                byteArray = new byte[tam];
                dataInputStream.readFully(byteArray);
                livro3.fromByteArray(byteArray);
                System.out.println(livro3);

                // livro4
                tam = dataInputStream.readInt();
                byteArray = new byte[tam];
                dataInputStream.readFully(byteArray);
                livro4.fromByteArray(byteArray);
                System.out.println(livro4);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}