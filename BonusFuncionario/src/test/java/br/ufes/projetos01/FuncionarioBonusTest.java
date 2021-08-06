package br.ufes.projetos01;

import br.ufes.calculodebonus.ProcessadoraBonus;
import br.ufes.model.Funcionario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author clayton e Pedro Henrique Robadel
 */
public class FuncionarioBonusTest {

    public FuncionarioBonusTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void CT001() throws Exception {
        
        assertThrows(Exception.class, () -> new Funcionario(null, 998.01, "Gerente") );
        
        
    }
    
    @Test
    public void CT002() throws Exception {
        
        assertThrows(Exception.class, () -> new Funcionario("Pedro", 998, "Gerente") );
        
    }
    
    @Test
    public void CT003() throws Exception {
        
        assertThrows(Exception.class, () -> new Funcionario("Pedro", 998.01, null) );
        
    }

    @Test
    public void CT004() throws Exception {
        // Organizar
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Gerente";
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        double salarioEsperado = 1147.9105;
        
        
        // Agir
        pb.processar(funcionario);
        
        
        // Afirmar
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(0, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT005() throws Exception {
        // Organizar
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Gerente";
        int faltas = -10;
        double salarioEsperado = 1147.9105;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        funcionario.setFaltas(faltas);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        
        // Agir
        pb.processar(funcionario);
        
        
        // Afirmar
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(faltas, funcionario.getFaltas());
        assertEquals(0, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT006() throws Exception {
        // Organizar
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Gerente";
        int faltas = 3;
        double salarioEsperado = 1117.9702;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        funcionario.setFaltas(faltas);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        
        // Agir
        pb.processar(funcionario);
        
        
        // Afirmar
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(faltas, funcionario.getFaltas());
        assertEquals(0, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT007() throws Exception {
        // Organizar
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Gerente";
        int faltas = 6;
        double salarioEsperado = 1107.9901;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        funcionario.setFaltas(faltas);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        
        // Agir
        pb.processar(funcionario);
        
        
        // Afirmar
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(faltas, funcionario.getFaltas());
        assertEquals(0, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT008() throws Exception {
        // Organizar
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Gerente";
        int faltas = 12;
        double salarioEsperado = 1098.01;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        funcionario.setFaltas(faltas);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        
        // Agir
        pb.processar(funcionario);
        
        
        // Afirmar
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(faltas, funcionario.getFaltas());
        assertEquals(0, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT009() throws Exception {
        // Organizar
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Gerente";
        int distancia = -10;
        double salarioEsperado = 1147.9105;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        funcionario.setDistanciaMoradia(distancia);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        
        // Agir
        pb.processar(funcionario);
        
        
        // Afirmar
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(distancia, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT010() throws Exception {
        // Organizar
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Gerente";
        int distancia = 60;
        double salarioEsperado = 1297.9105;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        funcionario.setDistanciaMoradia(distancia);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        
        // Agir
        pb.processar(funcionario);
        
        
        // Afirmar
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(distancia, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT011() throws Exception {
        // Organizar
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Gerente";
        int distancia = 110;
        double salarioEsperado = 1447.9105;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        funcionario.setDistanciaMoradia(distancia);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        
        // Agir
        pb.processar(funcionario);
        
        
        // Afirmar
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(distancia, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT012() throws Exception {
        // Organizar
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Gerente";
        int distancia = 160;
        double salarioEsperado = 1647.9105;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        funcionario.setDistanciaMoradia(distancia);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        
        // Agir
        pb.processar(funcionario);
        
        
        // Afirmar
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(distancia, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    
    @Test
    public void CT013() throws Exception {
        // Organizar
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Gerente";
        int distancia = 60;
        int faltas = 3;
        double salarioEsperado = 1267.9702;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        funcionario.setDistanciaMoradia(distancia);
        funcionario.setFaltas(faltas);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        
        // Agir
        pb.processar(funcionario);
        
        
        // Afirmar
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(faltas, funcionario.getFaltas());
        assertEquals(distancia, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    
    @Test
    public void CT014() throws Exception {
        // Organizar
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Supervisor";
        double salarioEsperado = 1127.9105;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        
        // Agir
        pb.processar(funcionario);
        
        
        // Afirmar
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(0, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    
    @Test
    public void CT015() throws Exception {
        // Organizar
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Programador";
        double salarioEsperado = 1097.9105;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        
        // Agir
        pb.processar(funcionario);
        
        
        // Afirmar
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(0, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT016() throws Exception {
        // Organizar
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Datilógrafo";
        double salarioEsperado = 1047.9105;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        
        // Agir
        pb.processar(funcionario);
        
        
        // Afirmar
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(0, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT017() throws Exception {
        // Organizar
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "";
        double salarioEsperado = 1047.9105;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        
        // Agir
        pb.processar(funcionario);
        
        
        // Afirmar
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(0, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT018() throws Exception {
        // Organizar
        String nome = "";
        double salarioBase = 998.01;
        String cargo = "Datilógrafo";
        double salarioEsperado = 1047.9105;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        
        // Agir
        pb.processar(funcionario);
        
        
        // Afirmar
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(0, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT019() throws Exception {
        // Organizar
        String nome = "";
        double salarioBase = 998.01;
        String cargo = "";
        double salarioEsperado = 1047.9105;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        
        // Agir
        pb.processar(funcionario);
        
        
        // Afirmar
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(0, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
}
