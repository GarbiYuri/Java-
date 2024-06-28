package concessionaria.concessionaria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ConcessionariaGUI extends Application {
    private Concessionaria concessionaria; // Instância da classe Concessionaria para gerenciar os dados




    // Declaração dos campos de texto para entrada de dados
    private TextField txtCarromarca, txtCarromode, txtCarrochassi, txtcarrofabri, txtcarropreco;
    private TextField txtUserName, txtUserIdade, txtUserNmrHabi, txtDin;
    private TextField txtCartid, txtCartquanti;
    private TextArea txtAreaDisplay; // Área de texto para exibição de mensagens
    private Button btnAddUser, btnRemoveUser, btnShowClientes; // Botões para adicionar usuário, remover usuário, mostrar clientes
    private Button btnAddCarro, btnShowCarro, btnRemoveCarro; // Botões para adicionar carro, mostrar carros, remover carro
    private Button btnAddCart, btnRemoveCart, btnAddDinheiroCart, btnRemoveDinheiroCart, btnLimpar; // Botões para adicionar carteira, remover carteira, adicionar dinheiro, remover dinheiro, limpar área

    @Override
    public void start(Stage primaryStage) {
        concessionaria = new Concessionaria(); // Inicializa a instância da concessionária
        primaryStage.setTitle("Sistema de Gerenciamento de Concessionária");

        BorderPane root = new BorderPane(); // Cria um layout BorderPane
        root.setPadding(new Insets(10)); // Define o espaçamento interno do layout

        // Configuração dos painéis da interface
        root.setTop(createCarroPanel()); // Painel para gerenciar informações de carros
        root.setLeft(createUserPanel()); // Painel para gerenciar informações de usuários
        root.setRight(createCartPanel()); // Painel para gerenciar informações de carteiras
        root.setCenter(createDisplayPanel()); // Painel central para exibir mensagens
        root.setBottom(createControlPanel()); // Painel de controle com botões de ação

        Scene scene = new Scene(root, 800, 600); // Cria a cena principal com o layout BorderPane
        primaryStage.setScene(scene); // Define a cena no palco principal
        primaryStage.show(); // Mostra a janela principal
    }

    // Cria o painel para gerenciar informações de carros
    private VBox createCarroPanel() {


        VBox panel = new VBox(1); // Cria um VBox com espaçamento vertical entre os nós
        panel.setPadding(new Insets(10)); // Define o espaçamento interno do painel
        panel.setAlignment(Pos.TOP_LEFT); // Alinha o conteúdo para o topo e à esquerda
        panel.getChildren().addAll( // Adiciona os componentes ao painel
                new Label("Marca Carro:"), txtCarromarca = new TextField(),
                new Label("Modelo Carro:"), txtCarromode = new TextField(),
                new Label("Número Chassi:"), txtCarrochassi = new TextField(),
                new Label("Ano Fabricação:"), txtcarrofabri = new TextField(),
                new Label("Preço do Carro:"), txtcarropreco = new TextField(),
                btnAddCarro = new Button("Adicionar Carro"),
                btnRemoveCarro = new Button("Remover Carro")
        );



        // Define a ação dos botões
        btnAddCarro.setOnAction(e -> addCarro()); // Adicionar carro
        btnRemoveCarro.setOnAction(e -> removeCarro()); // Remover carro

        return panel; // Retorna o painel de carros


    }

    // Cria o painel para gerenciar informações de usuários
    private VBox createUserPanel() {
        VBox panel = new VBox(1); // Cria um VBox com espaçamento vertical entre os nós
        panel.setPadding(new Insets(10)); // Define o espaçamento interno do painel
        panel.setAlignment(Pos.TOP_LEFT); // Alinha o conteúdo para o topo e à esquerda
        panel.getChildren().addAll( // Adiciona os componentes ao painel
                new Label("Nome do Usuário:"), txtUserName = new TextField(),
                new Label("Idade:"), txtUserIdade = new TextField(),
                new Label("Número Habilitação:"), txtUserNmrHabi = new TextField(),
                new Label("Id da Carteira:"), txtDin = new TextField(),
                btnAddUser = new Button("Adicionar Usuário"),
                btnRemoveUser = new Button("Remover Usuário")
        );

        // Define a ação dos botões
        btnAddUser.setOnAction(e -> addUser()); // Adicionar usuário
        btnRemoveUser.setOnAction(e -> removeUser()); // Remover usuário

        return panel; // Retorna o painel de usuários
    }

    // Cria o painel para gerenciar informações de carteiras
    private VBox createCartPanel() {
        VBox panel = new VBox(1); // Cria um VBox com espaçamento vertical entre os nós
        panel.setPadding(new Insets(10)); // Define o espaçamento interno do painel
        panel.setAlignment(Pos.TOP_LEFT); // Alinha o conteúdo para o topo e à esquerda
        panel.getChildren().addAll( // Adiciona os componentes ao painel
                new Label("Id:"), txtCartid = new TextField(),
                new Label("Dinheiro Inicial:"), txtCartquanti = new TextField(),
                btnAddCart = new Button("Adicionar Carteira"),
                btnRemoveCart = new Button("Remover Carteira"),
                btnAddDinheiroCart = new Button("Adicionar Dinheiro"),
                btnRemoveDinheiroCart = new Button("Remover Quantia")
        );

        // Define a ação dos botões
        btnAddCart.setOnAction(e -> addCart()); // Adicionar carteira
        btnRemoveCart.setOnAction(e -> removeCart()); // Remover carteira
        btnAddDinheiroCart.setOnAction(e -> addMoney()); // Adicionar dinheiro à carteira
        btnRemoveDinheiroCart.setOnAction(e -> removeMoney()); // Remover dinheiro da carteira

        return panel; // Retorna o painel de carteiras
    }

    // Cria o painel de controle com botões de ação
    private VBox createControlPanel() {
        HBox panel = new HBox(10); // Cria um HBox com espaçamento horizontal entre os nós
        panel.setPadding(new Insets(10)); // Define o espaçamento interno do painel
        panel.setAlignment(Pos.CENTER); // Alinha o conteúdo ao centro
        panel.getChildren().addAll( // Adiciona os botões ao painel
                btnLimpar = new Button("Limpar Área"),
                btnShowCarro = new Button("Mostrar Carros"),
                new Button("Comprar Carro") {{
                    setOnAction(e -> comprarCarro()); // Ação para comprar carro
                }},
                btnShowClientes = new Button("Mostrar Clientes")
        );

        // Define a ação dos botões
        btnLimpar.setOnAction(e -> txtAreaDisplay.clear()); // Limpar a área de exibição
        btnShowCarro.setOnAction(e -> showCarros()); // Mostrar lista de carros
        btnShowClientes.setOnAction(e -> showClientes()); // Mostrar lista de clientes

        VBox container = new VBox(panel); // Cria um VBox para adicionar o painel de controle
        container.setAlignment(Pos.CENTER); // Alinha o conteúdo ao centro
        return container; // Retorna o painel de controle
    }

    // Cria o painel central para exibição de mensagens
    private VBox createDisplayPanel() {
        VBox panel = new VBox(10); // Cria um VBox com espaçamento vertical entre os nós
        panel.setPadding(new Insets(10)); // Define o espaçamento interno do painel
        panel.setAlignment(Pos.CENTER); // Alinha o conteúdo ao centro
        txtAreaDisplay = new TextArea(); // Cria uma área de texto
        txtAreaDisplay.setEditable(false); // Define a área de texto como somente leitura
        txtAreaDisplay.setPrefHeight(300); // Define a altura preferencial da área de texto
        panel.getChildren().add(txtAreaDisplay); // Adiciona a área de texto ao painel
        return panel; // Retorna o painel de exibição
    }

    // Método para realizar a compra de um carro
    private void comprarCarro() {
        String nomeCliente = getInput("Digite o nome do Cliente:"); // Obtém o nome do cliente
        int chassic = Integer.parseInt(getInput("Digite o Chassi do Carro:")); // Obtém o chassi do carro

        Cliente cliente = concessionaria.findClienteByNome(nomeCliente); // Procura o cliente pelo nome
        if (cliente != null) {
            if (concessionaria.comprarCarro(cliente, chassic)) { // Tenta comprar o carro
                txtAreaDisplay.appendText("Carro comprado com sucesso!\n"); // Exibe mensagem de sucesso
            } else {
                txtAreaDisplay.appendText("Falha na compra do carro. Verifique o chassi e saldo do cliente.\n"); // Exibe mensagem de falha na compra
            }
        } else {
            txtAreaDisplay.appendText("Cliente não encontrado.\n"); // Exibe mensagem se o cliente não for encontrado
        }
    }

    // Método para adicionar um carro
    private void addCarro() {
        try {
            String marca = txtCarromarca.getText(); // Obtém a marca do carro
            String modelo = txtCarromode.getText(); // Obtém o modelo do carro
            int chassi = Integer.parseInt(txtCarrochassi.getText()); // Obtém o número do chassi
            int anoFabricacao = Integer.parseInt(txtcarrofabri.getText()); // Obtém o ano de fabricação
            double preco = Double.parseDouble(txtcarropreco.getText()); // Obtém o preço do carro

            if (concessionaria.isChassiExists(chassi)) { // Verifica se o chassi já existe
                txtAreaDisplay.appendText("Chassi já cadastrado, Carro não adicionado!\n"); // Exibe mensagem de chassi duplicado
            } else {
                concessionaria.cadastrarCarro(new Carro(marca, modelo, anoFabricacao, chassi, preco)); // Cadastra o carro na concessionária
                txtAreaDisplay.appendText("Carro: " + modelo + " Cadastrado com sucesso!!\n"); // Exibe mensagem de sucesso
            }

            clearCarroFields(); // Limpa os campos de entrada de dados de carro
        } catch (NumberFormatException e) {
            txtAreaDisplay.appendText("Formato Inválido\n"); // Exibe mensagem de erro se houver formato inválido
        }
    }

    // Método para remover um carro
    private void removeCarro() {
        int chassi = Integer.parseInt(getInput("Digite o Chassi do Carro:")); // Obtém o chassi do carro
        Carro carro = concessionaria.findCarroByChassi(chassi); // Procura o carro pelo chassi
        if (carro != null) {
            concessionaria.removerCarro(carro); // Remove o carro da concessionária
            txtAreaDisplay.appendText("Carro removido \n"); // Exibe mensagem de sucesso
        } else {
            txtAreaDisplay.appendText("Chassi não encontrado: " + chassi + "\n"); // Exibe mensagem se o chassi não for encontrado
        }
    }

    // Método para mostrar todos os carros disponíveis
    private void showCarros() {
        txtAreaDisplay.appendText("Carros Disponíveis: \n");
        for (Carro carro : concessionaria.getCarros()) { // Itera sobre todos os carros da concessionária
            txtAreaDisplay.appendText("Modelo: " + carro.getModelo() + ": \n" +
                    "Fabricado no ano: " + carro.getDataFabricacao() + " \n" +
                    "Da marca: " + carro.getMarca() + " \n" +
                    "Chassi: " + carro.getChassi() + " \n" +
                    "e preço: " + carro.getPreco()); // Exibe as informações do carro
            txtAreaDisplay.appendText("\n________________________________\n");
        }
    }

    // Método para mostrar todos os clientes cadastrados
    private void showClientes() {
        txtAreaDisplay.appendText("Clientes Disponíveis: \n");
        for (Cliente cliente : concessionaria.getClientes()) { // Itera sobre todos os clientes da concessionária
            txtAreaDisplay.appendText("Nome: " + cliente.getNome() +
                    " \n Idade: " + cliente.getIdade() +
                    " \n id Carteira: " + cliente.getCarteira().getIdcart() +
                    " \n Número Habilitação: " + cliente.getNumeroHabilitacao() +
                    " \n Dinheiro Na conta: " + cliente.puxarCarteira()); // Exibe as informações do cliente
            txtAreaDisplay.appendText("\n________________________________\n");
        }
    }

    // Método para adicionar um usuário
    private void addUser() {
        try {
            String nome = txtUserName.getText(); // Obtém o nome do usuário
            int idade = Integer.parseInt(txtUserIdade.getText()); // Obtém a idade do usuário
            int nmrhabi = Integer.parseInt(txtUserNmrHabi.getText()); // Obtém o número da habilitação do usuário
            int carteiraId = Integer.parseInt(txtDin.getText()); // Obtém o ID da carteira do usuário

            Carteira carteira = concessionaria.findCarteiraById(carteiraId); // Procura a carteira pelo ID
            if (carteira != null) {
                Cliente novoCliente = new Cliente(nome, idade, nmrhabi, carteiraId, carteira); // Cria um novo cliente
                concessionaria.cadastrarCliente(novoCliente); // Cadastra o cliente na concessionária
                txtAreaDisplay.appendText("Cliente: " + nome + " Cadastrado com sucesso!!\n"); // Exibe mensagem de sucesso
            } else {
                txtAreaDisplay.appendText("Id de Carteira não encontrado!!\n"); // Exibe mensagem se a carteira não for encontrada
            }

            clearUserFields(); // Limpa os campos de entrada de dados do usuário
        } catch (NumberFormatException e) {
            txtAreaDisplay.appendText("Formato Inválido\n"); // Exibe mensagem de erro se houver formato inválido
        }
    }

    // Método para remover um usuário
    private void removeUser() {
        String nome = getInput("Digite o Nome do Cliente:"); // Obtém o nome do cliente
        Cliente cliente = concessionaria.findClienteByNome(nome); // Procura o cliente pelo nome
        if (cliente != null) {
            concessionaria.removerCliente(cliente); // Remove o cliente da concessionária
            txtAreaDisplay.appendText("Cliente removido \n"); // Exibe mensagem de sucesso
        } else {
            txtAreaDisplay.appendText("Cliente não encontrado: " + nome + "\n"); // Exibe mensagem se o cliente não for encontrado
        }
    }

    // Método para adicionar uma carteira
    private void addCart() {
        try {
            int id = Integer.parseInt(txtCartid.getText()); // Obtém o ID da carteira
            double quantia = Double.parseDouble(txtCartquanti.getText()); // Obtém a quantidade inicial de dinheiro

            if (concessionaria.isCarteiraExists(id)) { // Verifica se o ID da carteira já existe
                txtAreaDisplay.appendText("Id Carteira já cadastrado!!\n"); // Exibe mensagem de ID de carteira duplicado
            } else {
                concessionaria.cadastrarCarteira(new Carteira(id, quantia)); // Cadastra a carteira na concessionária
                txtAreaDisplay.appendText("Carteira cadastrada com sucesso!!\n"); // Exibe mensagem de sucesso
            }

            clearCartFields(); // Limpa os campos de entrada de dados da carteira
        } catch (NumberFormatException e) {
            txtAreaDisplay.appendText("Formato Inválido\n"); // Exibe mensagem de erro se houver formato inválido
        }
    }

    // Método para remover uma carteira
    private void removeCart() {
        int id = Integer.parseInt(getInput("Digite o id da Carteira:")); // Obtém o ID da carteira
        Carteira carteira = concessionaria.findCarteiraById(id); // Procura a carteira pelo ID
        if (carteira != null) {
            if (concessionaria.isCarteiraSincronizada(id)) { // Verifica se a carteira está sincronizada com um usuário
                txtAreaDisplay.appendText("Carteira está Sincronizada a um Usuário!\n"); // Exibe mensagem se a carteira estiver sincronizada
            } else {
                concessionaria.removerCarteira(carteira); // Remove a carteira da concessionária
                txtAreaDisplay.appendText("Carteira Removida: " + id + "\n"); // Exibe mensagem de sucesso
            }
        } else {
            txtAreaDisplay.appendText("Id não encontrado: " + id + "\n"); // Exibe mensagem se o ID não for encontrado
        }
    }

    // Método para adicionar dinheiro a uma carteira
    private void addMoney() {
        int id = Integer.parseInt(getInput("Digite o id da Carteira:")); // Obtém o ID da carteira
        double quantia = Double.parseDouble(getInput("Digite a quantia a adicionar:")); // Obtém a quantia a adicionar

        try {
            Carteira carteira = concessionaria.findCarteiraById(id); // Procura a carteira pelo ID
            if (carteira != null) {
                carteira.colocarmais(id, quantia); // Adiciona dinheiro à carteira
                txtAreaDisplay.appendText("Dinheiro adicionado à carteira id: " + id + "\n"); // Exibe mensagem de sucesso
            } else {
                txtAreaDisplay.appendText("Carteira não encontrada!\n"); // Exibe mensagem se a carteira não for encontrada
            }
        } catch (NumberFormatException e) {
            txtAreaDisplay.appendText("Formato Inválido"); // Exibe mensagem de erro se houver formato inválido
        }
    }



// Método para remover dinheiro de uma carteira
    private void removeMoney() {
        int id = Integer.parseInt(getInput("Digite o id da Carteira:")); // Obtém o ID da carteira
        double quantia = Double.parseDouble(getInput("Digite a quantia a remover:")); // Obtém a quantia a remover

        try {
            Carteira carteira = concessionaria.findCarteiraById(id); // Procura a carteira pelo ID
            if (carteira != null) {
                carteira.removerumpouco(id, quantia); // Remove dinheiro da carteira
                txtAreaDisplay.appendText("Dinheiro removido da carteira id: " + id + "\n"); // Exibe mensagem de sucesso
            } else {
                txtAreaDisplay.appendText("Carteira não encontrada!\n"); // Exibe mensagem se a carteira não for encontrada
            }
        } catch (NumberFormatException e) {
            txtAreaDisplay.appendText("Formato Inválido\n"); // Exibe mensagem de erro se houver formato inválido
        }
    }

    // Método auxiliar para limpar os campos de entrada de dados de carro
    private void clearCarroFields() {
        txtCarromarca.clear();
        txtCarromode.clear();
        txtCarrochassi.clear();
        txtcarrofabri.clear();
        txtcarropreco.clear();
    }

    // Método auxiliar para limpar os campos de entrada de dados de usuário
    private void clearUserFields() {
        txtUserName.clear();
        txtUserIdade.clear();
        txtUserNmrHabi.clear();
        txtDin.clear();
    }

    // Método auxiliar para limpar os campos de entrada de dados de carteira
    private void clearCartFields() {
        txtCartid.clear();
        txtCartquanti.clear();
    }

    // Método auxiliar para obter entrada do usuário via caixa de diálogo
    private String getInput(String prompt) {
        TextInputDialog dialog = new TextInputDialog(); // Cria uma caixa de diálogo para entrada de texto
        dialog.setHeaderText(null); // Remove o cabeçalho da caixa de diálogo
        dialog.setContentText(prompt); // Define o texto de prompt da caixa de diálogo
        dialog.showAndWait(); // Mostra a caixa de diálogo e espera até que o usuário responda
        return dialog.getResult(); // Retorna a entrada do usuário
    }

    // Método principal para iniciar a aplicação JavaFX
    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }
}
