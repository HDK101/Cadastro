package br.scl.ifsp.edu.registerapp;

public class RegisterData {
    private String name;
    private String phone;
    private String email;
    private boolean emailCheckbox;
    private Gender gender;
    private String cidade;
    private String estate;

    public RegisterData(String name, String phone, String email, boolean emailCheckbox, Gender gender, String cidade, String estate) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.emailCheckbox = emailCheckbox;
        this.gender = gender;
        this.cidade = cidade;
        this.estate = estate;
    }

    @Override
    public String toString() {
        return "RegisterData{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", emailCheckbox=" + emailCheckbox +
                ", gender=" + gender +
                ", cidade='" + cidade + '\'' +
                ", estate='" + estate + '\'' +
                '}';
    }
}
