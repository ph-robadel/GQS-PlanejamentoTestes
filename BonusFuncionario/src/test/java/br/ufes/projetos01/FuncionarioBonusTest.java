package br.ufes.projetos01;

import br.ufes.calculodebonus.ProcessadoraBonus;
import br.ufes.model.Funcionario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author clayton e Pedro Henrique Robadel
 * Atv. de Revisão - Maycon R.
 * https://docs.google.com/document/d/1QFUJd5PcUs7fWbFeCG7x_J9LVLZLwTrS9LiSHw0yB4U/edit?usp=sharing - Link do Documento - Atv. de Revisão
 * https://docs.google.com/spreadsheets/d/1xnd_1KdGb8b-ETzpsx4Qn41PCdPbyI5MKQa-KkAtEUw/edit?usp=sharing - Link da Planilha - Atv. de Revisão
 */
public class FuncionarioBonusTest {

    public FuncionarioBonusTest() {
    }

    @Test
    public void CT001() throws Exception {
        assertThrows(Exception.class, () -> new Funcionario(null, 998.01, "Gerente", 0, 50) );   
    }
    
    @Test
    public void CT002() throws Exception {
        assertThrows(Exception.class, () -> new Funcionario("Pedro", 0, "Gerente", 0, 50) );
    }
    
    @Test
    public void CT003() throws Exception {
        assertThrows(Exception.class, () -> new Funcionario("Pedro", 998.01, null, 0, 50) );
    }

    @Test
    public void CT004() throws Exception {
        // Arrange
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Gerente";
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        double salarioEsperado = 1147.9105;
        
        // Act
        pb.processar(funcionario);
        
        // Assert
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(0, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT005() throws Exception {
        // Arrange
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Gerente";
        int faltas = -10;
        
        // Assert
        String mensagemEsperada = "\n#4 A quantidade de faltas não pode ser < 0";
        Exception e = assertThrows(Exception.class, () ->{
            new Funcionario(nome, salarioBase, cargo, faltas, 0);
            
        });
        
        assertEquals(mensagemEsperada, e.getMessage());
    }
    
    @Test
    public void CT006() throws Exception {
        // Arrange
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Gerente";
        int faltas = 3;
        double salarioEsperado = 1117.9702;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        funcionario.setFaltas(faltas);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        // Act
        pb.processar(funcionario);
        
        // Assert
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(faltas, funcionario.getFaltas());
        assertEquals(0, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT007() throws Exception {
        // Arrange
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Gerente";
        int faltas = 6;
        double salarioEsperado = 1107.9901;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        funcionario.setFaltas(faltas);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        
        // Act
        pb.processar(funcionario);
        
        // Assert
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(faltas, funcionario.getFaltas());
        assertEquals(0, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT008() throws Exception {
        // Arrange
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Gerente";
        int faltas = 12;
        double salarioEsperado = 1098.01;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        funcionario.setFaltas(faltas);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        // Act
        pb.processar(funcionario);
        
        // Assert
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(faltas, funcionario.getFaltas());
        assertEquals(0, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT009() throws Exception {
        // Arrange
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Gerente";
        int distancia = -10;
        
        //String mensagemEsperada = "Distância inválida";
        
        assertThrows(Exception.class, () -> {
            new Funcionario(nome, salarioBase, cargo, 0, distancia);
        }); 
    }
    
    @Test
    public void CT010() throws Exception {
        // Arrange
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Gerente";
        int distancia = 60;
        double salarioEsperado = 1297.9105;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        funcionario.setDistanciaMoradia(distancia);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        // Act
        pb.processar(funcionario);
        
        // Assert
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(distancia, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT011() throws Exception {
        // Arrange
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Gerente";
        int distancia = 110;
        double salarioEsperado = 1447.9105;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        funcionario.setDistanciaMoradia(distancia);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        // Act
        pb.processar(funcionario);
        
        // Assert
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(distancia, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT012() throws Exception {
        // Arrange
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Gerente";
        int distancia = 160;
        double salarioEsperado = 1647.9105;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        funcionario.setDistanciaMoradia(distancia);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        // Act
        pb.processar(funcionario);
        
        // Assert
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(distancia, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    
    @Test
    public void CT013() throws Exception {
        // Arrange
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
        
        
        // Act
        pb.processar(funcionario);
        
        // Assert
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(faltas, funcionario.getFaltas());
        assertEquals(distancia, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    
    @Test
    public void CT014() throws Exception {
        // Arrange
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Supervisor";
        double salarioEsperado = 1127.9105;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        // Act
        pb.processar(funcionario);
        
        // Assert
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(0, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    
    @Test
    public void CT015() throws Exception {
        // Arrange
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Programador";
        double salarioEsperado = 1097.9105;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        // Act
        pb.processar(funcionario);
        
        // Assert
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(0, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT016() throws Exception {
        // Arrange
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "Datilógrafo";
        double salarioEsperado = 1047.9105;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        // Act
        pb.processar(funcionario);
        
        // Assert
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(0, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT017() throws Exception {
        // Arrange
        String nome = "Pedro";
        double salarioBase = 998.01;
        String cargo = "";
        double salarioEsperado = 1047.9105;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        // Act
        pb.processar(funcionario);
        
        // Assert
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(0, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT018() throws Exception {
        // Arrange
        String nome = "";
        double salarioBase = 998.01;
        String cargo = "Datilógrafo";
        double salarioEsperado = 1047.9105;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        // Act
        pb.processar(funcionario);
        
        // Assert
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(0, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    @Test
    public void CT019() throws Exception {
        // Arrange
        String nome = "";
        double salarioBase = 998.01;
        String cargo = "";
        double salarioEsperado = 1047.9105;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo);
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        // Act
        pb.processar(funcionario);
        
        // Assert
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(0, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);
    }
    
    /*NOVOS CASOS DE TESTES - MAYCON*/
    
    @Test
    public void CT020() throws Exception {
        //Arrange
        String nome = "Pedro";
        double salarioBase = 998.00;
        String cargo = "Gerente";
        double salarioEsperado = 1147.90;
        int faltas = 0;
        int distanciaMoradia = 30;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo, faltas, distanciaMoradia);
        
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        // Act
        pb.processar(funcionario);
        
        // Assert
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(30, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);     
    }
    
    @Test
    public void CT021() throws Exception {
        //Arrange
        String nome = "Pedro";
        double salarioBase = 998.00;
        String cargo = "Gerente de Projetos";
        double salarioEsperado = 1147.90;
        int faltas = 0;
        int distanciaMoradia = 30;
        
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo, faltas, distanciaMoradia);
        
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        // Act
        pb.processar(funcionario);
        
        // Assert
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(30, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001);     
    }
    
    @Test
    public void CT022() throws Exception {
        //Arrange
        String nome = "Pedro";
        double salarioBase = 998.00;
        String cargo = "Gerente";
        int faltas = 0;
        int distanciaMoradia = 30;
        
        double salarioEsperado = 1147.90;
        Funcionario funcionario = new Funcionario(nome, salarioBase, cargo, faltas, distanciaMoradia);
        
        ProcessadoraBonus pb = new ProcessadoraBonus();
        
        // Act
        pb.processar(funcionario);
        pb.processar(funcionario);
        
        // Assert
        assertEquals(nome, funcionario.getNome());
        assertEquals(salarioBase, funcionario.getSalarioBase(), 0.001);
        assertEquals(cargo, funcionario.getCargo());
        assertEquals(0, funcionario.getFaltas());
        assertEquals(30, funcionario.getDistanciaMoradia());
        assertEquals(salarioEsperado, funcionario.getSalario(), 0.001); 
    }
    
    
    @Test
    public void CT023() throws Exception {
        //Arrange
        String nome = "Pedro";
        String cargo = "Gerente";
        double salarioBase = 998.00;
        int faltas = 0;
        int distanciaMoradia = 30;
        
        String mensagemEsperada = "Salário base inválido";
        
        Exception e = assertThrows(Exception.class, () -> {
            Funcionario funcionario = new Funcionario(nome, salarioBase, cargo, faltas, distanciaMoradia);
            funcionario.setSalarioBase(997.00);
            ProcessadoraBonus pb = new ProcessadoraBonus();

            // Act
            pb.processar(funcionario);
        }); 
        
        
//      Assert
        assertEquals(mensagemEsperada, e.getMessage()); 
    }
    
    @Test
    public void CT024() throws Exception {
        //Arrange
        String nome = "Pedro";
        String cargo = "Gerente";
        double salarioBase = 998.00;
        int faltas = 0;
        int distanciaMoradia = 30;
        
        String mensagemEsperada = "Nome inválido";
        
        Exception e = assertThrows(Exception.class, () -> {
            Funcionario funcionario = new Funcionario(nome, salarioBase, cargo, faltas, distanciaMoradia);
            funcionario.setNome(null);
            ProcessadoraBonus pb = new ProcessadoraBonus();

            //Act
            pb.processar(funcionario);
        }); 
        
        
        //Assert
        assertEquals(mensagemEsperada, e.getMessage());  
    }
    
    @Test
    public void CT025() throws Exception {
        //Arrange
        String nome = "Pedro";
        String cargo = "Gerente";
        double salarioBase = 998.00;
        int faltas = 0;
        int distanciaMoradia = 30;
        
        String mensagemEsperada = "Cargo inválido";
        
        Exception e = assertThrows(Exception.class, () -> {
            Funcionario funcionario = new Funcionario(nome, salarioBase, cargo, faltas, distanciaMoradia);
            funcionario.setCargo("");
            ProcessadoraBonus pb = new ProcessadoraBonus();

            //Act
            pb.processar(funcionario);
        }); 
        
        
        //Assert
        assertEquals(mensagemEsperada, e.getMessage());   
    }
    
    @Test
    public void CT026() throws Exception {
        //Arrange
        String nome = "Pedro";
        double salarioBase = 998.00;
        String cargo = "Gerente";
        int faltas = 0;
        int distanciaMoradia = 30;
        
        String mensagemEsperada = "Quantidade de faltas inválida";
        
        Exception e = assertThrows(Exception.class, () -> {
            Funcionario funcionario = new Funcionario(nome, salarioBase, cargo, faltas, distanciaMoradia);
            funcionario.setFaltas(-1);
            ProcessadoraBonus pb = new ProcessadoraBonus();

            // Act
            pb.processar(funcionario);
        }); 
        
        
        //Assert
        assertEquals(mensagemEsperada, e.getMessage());  
    }
}
