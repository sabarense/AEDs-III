package javaIO;

import java.io.*;
import java.text.DecimalFormat;

public class Livro {
    DecimalFormat decimalFormat = new DecimalFormat("#, ##0.00");
    private int idLivro;
    private String titulo;
    private String autor;
    private float preco;

    public Livro(int idLivro, String titulo, String autor, float preco) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    public Livro() {
        this.idLivro = -1;
        this.titulo = "";
        this.autor = "";
        this.preco = 0F;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    @Override
    public String toString() {
        return "Livro { " +
                "idLivro = " + idLivro +
                ", titulo = '" + titulo + '\'' +
                ", autor = '" + autor + '\'' +
                ", preco = " + decimalFormat.format(preco) +
                '}';
    }

    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeInt(this.getIdLivro());
        dataOutputStream.writeUTF(this.getTitulo());
        dataOutputStream.writeUTF(this.getAutor());
        dataOutputStream.writeFloat(this.getPreco());
        dataOutputStream.close();
        return  byteArrayOutputStream.toByteArray();
    }

    public void fromByteArray(byte[] byteArray) throws  IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        this.setIdLivro(dataInputStream.readInt());
        this.setTitulo(dataInputStream.readUTF());
        this.setAutor(dataInputStream.readUTF());
        this.setPreco(dataInputStream.readFloat());
    }
}
