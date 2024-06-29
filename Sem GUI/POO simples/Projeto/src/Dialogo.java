import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
public class Dialogo extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;

    public Dialogo() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }


    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

        public static void main(String[] args) {
            Dialogo dialog = new Dialogo();
            dialog.pack();
            dialog.setVisible(true);
            Scanner scanner = new Scanner(System.in);
            Pessoa pessoa = new Pessoa();


            System.out.println("Digite o nome:");
            pessoa.setNome(scanner.nextLine());
            System.out.println("Informe seu Sexo:");
            pessoa.setSexo(scanner.nextLine());
            System.out.println("Informe sua idade:");
            pessoa.setIdade(Integer.parseInt(scanner.nextLine()));
            System.out.println("Informe sua estatura:");
            pessoa.setEstatura(Double.parseDouble(scanner.nextLine()));
            System.out.println("Fale algo para o Mundo:");
            String text = pessoa.falar(scanner.nextLine());

            pessoa.andar();

            System.out.println("\n");


            System.out.println(text);
        }

    //A Classe Dialogo.Pessoa
    public static class Pessoa {
        //Atributos da classe
        private String nome;
        private String sexo;
        private int idade;
        private double estatura;

        // Criando os métodos de acesso
        //getters e setters


        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getSexo() {
            return sexo;
        }

        public void setSexo(String sexo) {
            this.sexo = sexo;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        public double getEstatura() {
            return estatura;
        }

        public void setEstatura(double estatura) {
            this.estatura = estatura;
        }
        //Criando os métodos
        public void andar(){
            System.out.println("A pessoa com nome "+this.nome+
                    " do sexo "+this.sexo+
                    " que tem a idade "+this.idade+
                    " e com estatura "+this.estatura+
                    " está andando..."+"\n");
        }

        public String falar(String texto){
            return "a pessoa com o nome: "+this.nome+"\n"+
                    "do sexo: "+this.sexo+"\n"+
                    "que tem a idade: "+this.idade+"\n"+
                    "e com estatura: "+this.estatura+"\n"+
                    "está falando: " + texto;

        }
    }
}

