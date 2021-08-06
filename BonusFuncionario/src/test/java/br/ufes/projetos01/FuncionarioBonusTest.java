package br.ufes.projetos01;

import br.ufes.calculodebonus.ProcessadoraBonus;
import br.ufes.model.Funcionario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author clayton
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
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");

        double salarioEsperado = 2500.00;

        assertEquals(salarioEsperado, funcionario.getSalarioBase(), 0.001);
    }

    @Test
    public void CT002() throws Exception {
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");

        funcionario.setFaltas(2);

        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        double salarioEsperado = 2650.00;

        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT003() throws Exception {
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");

        funcionario.setFaltas(2);
        funcionario.setDistanciaMoradia(101);

        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        double salarioEsperado = 2950.00;

        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }

    @Test
    public void CT004() throws Exception {
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");

        funcionario.setFaltas(2);
        funcionario.setDistanciaMoradia(151);

        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        double salarioEsperado = 3150.00;

        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
     @Test
    public void CT005() throws Exception {
        Funcionario funcionario = new Funcionario("Fulano", 2500.00, "Gerente");

        funcionario.setFaltas(2);
        funcionario.setDistanciaMoradia(51);

        ProcessadoraBonus pb = new ProcessadoraBonus();
        pb.processar(funcionario);

        double salarioEsperado = 2800.00;

        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
}
