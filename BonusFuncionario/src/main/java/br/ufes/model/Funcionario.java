package br.ufes.model;

import java.util.ArrayList;

public class Funcionario {

    private String nome;
    private double salarioBase;
    private double salarioTotal;
    private int distanciaMoradia;
    private int faltas;
    private String cargo;
    private final ArrayList<Bonus> bonusRecebidos;

    public Funcionario(String nome, double salarioBase, String cargo, int faltas, int distanciaMoradia) throws Exception {
        String exceptions = "";

        if (nome == null) {
            exceptions = exceptions.concat("\n#1 Informe um nome válido");
        }

        if (cargo == null) {
            exceptions = exceptions.concat("\n#2 Informe um cargo válido");
        }
        if (salarioBase < 998.0) {
            exceptions = exceptions.concat("\n#3 O salário base deve ser >= R$ 998,00");
        }
        if (faltas < 0) {
            exceptions = exceptions.concat("\n#4 A quantidade de faltas não pode ser < 0");
        }
        if (distanciaMoradia < 0) {
            exceptions = exceptions.concat("\n#4 A distância não pode ser < 0");
        }

        if (exceptions.length() > 0) {
            throw new Exception(exceptions);
        }
        this.nome = nome;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.bonusRecebidos = new ArrayList<>();
        this.faltas = faltas;
        this.distanciaMoradia = distanciaMoradia;
    }

    public Funcionario(String nome, double salarioBase, String cargo) throws Exception {
        String exceptions = "";

        if (nome == null) {
            exceptions = exceptions.concat("\n#1 Informe um nome válido");
        }

        if (cargo == null) {
            exceptions = exceptions.concat("\n#2 Informe um cargo válido");
        }
        if (salarioBase < 998.0) {
            exceptions = exceptions.concat("\n#3 O salário base deve ser >= R$ 998,00");
        }

        if (exceptions.length() > 0) {
            throw new Exception(exceptions);
        }
        this.nome = nome;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.bonusRecebidos = new ArrayList<>();
        this.faltas = faltas;
        this.distanciaMoradia = distanciaMoradia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception{
        this.nome = nome;
        if (nome == null || nome == "") 
            throw new Exception ("Nome inválido");
    }

    public double getSalarioBase() {
        return this.salarioBase;
    }

    public void setSalarioBase(double salarioBase) throws Exception{
        this.salarioBase = salarioBase;
        if(this.salarioBase != 998.00){
            throw new Exception ("Salário base inválido");
        }
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) throws Exception{
        this.faltas = faltas;
        if (this.faltas < 0)
            throw new Exception ("Quantidade de faltas inválida");
    }

    public int getDistanciaMoradia() {
        return distanciaMoradia;
    }

    public void setDistanciaMoradia(int distanciaMoradia) throws Exception{
        this.distanciaMoradia = distanciaMoradia;
        if(this.distanciaMoradia < 0){
            throw new Exception ("Distância inválida");
        }
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) throws Exception{
        this.cargo = cargo;
        if (cargo == null || cargo=="")
            throw new Exception ("Cargo inválido");
    }

    public double getSalario() {
        return this.calculaSalario();
    }

    private double calculaSalario() {
        this.salarioTotal = this.salarioBase + this.calculaTotalBonus();
        return this.salarioTotal;
    }

    public void addBonus(Bonus bonus) {
        if(this.bonusRecebidos.contains(bonus)) {
            this.bonusRecebidos.remove(bonus);
        }
        
        this.bonusRecebidos.add(bonus);
    }

    public double calculaTotalBonus() {
        double totalBonus = 0;
        for (Bonus bonus : bonusRecebidos) {
            totalBonus += bonus.getValor();
        }

        return totalBonus;
    }

    @Override
    public String toString() {
        String strBonusRecebidos = "";
        for (Bonus bonusRecebido : bonusRecebidos) {
            strBonusRecebidos += "\n\t" + bonusRecebido;
        }
        String strFuncionario = "Funcionario {"
                + "nome: " + this.nome + ", "
                + "salarioBase: " + this.salarioBase + ", "
                + "totalBonus: " + this.calculaTotalBonus() + ", "
                + "salarioTotal: " + this.getSalario()
                + '}';

        if (bonusRecebidos.size() > 0) {
            strFuncionario += "\nBonus recebidos: " + strBonusRecebidos;
        }

        return strFuncionario;
    }
}
