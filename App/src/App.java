import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static class FichaCadastral {

        int id;
        String nomeProduto;
        String categoria;
        float quantidadeEstoque;
        double preco;
    }

    public static void main(String[] args) throws Exception {

        Scanner teclado = new Scanner(System.in);

        String escolha = "0";
        int cont = 1;
        List<FichaCadastral> cadastrosList = new ArrayList<>();
        int escolhaIdAtualizarPdt = 0;
        boolean avisoIdNaoEncontrado = true;
        String opcaoAlteracao = "0";

        do {
            System.out.println("Seja bem vindo(a) ao gerenciador de produtos da Boutique Arcanum Lux - Exclusividade e Legado!");
            System.out.println("================================================================");
            System.out.println("                        MENU DE OPÇÕES                          ");
            System.out.println("================================================================");
            System.out.println("1 - ADICIONAR PRODUTO");
            System.out.println("2 - LISTAR PRODUTOS");
            System.out.println("3 - ATUALIZAR PRODUTO");
            System.out.println("4 - EXCLUIR PRODUTO");
            System.out.println("5 - BUSCAR PRODUTO");
            System.out.println("0 - ENCERRAR");
            System.out.println("================================================================");
            System.out.println("Escolha sua opção de acordo com a numeração acima!");

            escolha = teclado.nextLine();

            switch (escolha) {
                case "1":
                    String rConfirmacaoCadst;
                    do {
                        FichaCadastral novoCadastro = new FichaCadastral();

                        System.out.println("Digite o nome do produto que deseja cadastrar:");
                        novoCadastro.nomeProduto = teclado.nextLine();

                        System.out.println("Digite a categoria do produto:");
                        novoCadastro.categoria = teclado.nextLine();

                        System.out.println("Digite a quantidade em número do produto disponível em estoque:");
                        novoCadastro.quantidadeEstoque = teclado.nextFloat();

                        System.out.println("Digite o preço unitário do produto:");
                        System.out.printf("R$ ");
                        novoCadastro.preco = teclado.nextDouble();

                        System.out.println("================================================================");
                        System.out.println("Confirmação de dados do cadastro:");
                        System.out.println("Nome do Produto: " + novoCadastro.nomeProduto);
                        System.out.println("Categoria: " + novoCadastro.categoria);
                        System.out.println("Quantidade em estoque: " + novoCadastro.quantidadeEstoque);
                        System.out.println("Preço unitário: R$" + novoCadastro.preco);
                        System.out.println("================================================================");

                        teclado.nextLine(); // limpar buffer
                        System.out.println("Você confirma os dados digitados para cadastro? S/N");
                        rConfirmacaoCadst = teclado.nextLine().toUpperCase();

                        if (!rConfirmacaoCadst.equals("S")) {
                            System.out.println("================================================================");
                            System.out.println("      Cadastro não realizado. Voltando ao menu inicial.");
                            System.out.println("================================================================\n");
                        } else {
                            System.out.println("================================================================");
                            System.out.println("      Parabéns, seu produto foi cadastrado com sucesso!");
                            System.out.println("================================================================\n");
                            novoCadastro.id = cont;
                            cont++;
                            cadastrosList.add(novoCadastro);
                        }

                    } while (!rConfirmacaoCadst.equals("S"));
                    break;

                case "2":
                    System.out.println("================================================================");
                    System.out.println("                Exibição dos itens da lista:");

                    if (cadastrosList.isEmpty()) {
                        System.out.println("================================================================");
                        System.out.println("            Não há produtos cadastrados na lista.");
                        System.out.println("================================================================");
                    } else {
                        for (FichaCadastral obj : cadastrosList) {
                            System.out.println("================================================================");
                            System.out.println("Id: " + obj.id);
                            System.out.println("Nome do Produto: " + obj.nomeProduto);
                            System.out.println("Categoria: " + obj.categoria);
                            System.out.println("Quantidade em estoque: " + obj.quantidadeEstoque);
                            System.out.println("Preço unitário: R$" + obj.preco);
                            System.out.println("================================================================");
                        }
                    }
                    break;

                case "3":
                    System.out.println("================================================================");
                    System.out.println("               Exibindo produtos da lista.");

                    for (FichaCadastral obj : cadastrosList) {
                        System.out.println("================================================================");
                        System.out.println("Id: " + obj.id);
                        System.out.println("Nome do Produto: " + obj.nomeProduto);
                        System.out.println("================================================================");
                    }
                    System.out.println("Digite o número do id do produto que deseja atualizar:");
                    escolhaIdAtualizarPdt = teclado.nextInt();

                    FichaCadastral produtoParaAtualizar = null;
                    avisoIdNaoEncontrado = true;
                    for (FichaCadastral obj : cadastrosList) {

                        if (obj.id == escolhaIdAtualizarPdt) {
                            produtoParaAtualizar = obj;
                            System.out.println("================================================================");
                            System.out.println("      Estes são os dados referentes ao produto selecionado:");
                            System.out.println("================================================================");
                            System.out.println("Id: " + obj.id);
                            System.out.println("Nome do Produto: " + obj.nomeProduto);
                            System.out.println("Categoria: " + obj.categoria);
                            System.out.println("Quantidade em estoque: " + obj.quantidadeEstoque);
                            System.out.println("Preço unitário: R$" + obj.preco);
                            System.out.println("================================================================");
                            teclado.nextLine(); // Limpa o buffer
                            avisoIdNaoEncontrado = false;
                            break;
                        }
                    }

                    if (produtoParaAtualizar != null) {
                        boolean atualizar = true;
                        while (atualizar) {
                            System.out.println("================================================================");
                            System.out.println("     Qual campo referente ao produto você deseja atualizar?");
                            System.out.println("================================================================");
                            System.out.println("1 - Nome do Produto");
                            System.out.println("2 - Categoria");
                            System.out.println("3 - Quantidade em estoque");
                            System.out.println("4 - Preço unitário");
                            System.out.println("5 - Cancelar");
                            System.out.println("================================================================");
                            System.out.println("Escolha sua opção de acordo com a numeração acima!");
                            System.out.println("================================================================");
                            opcaoAlteracao = teclado.nextLine();

                            String novoNome;
                            String novaCategoria;
                            float novaQuantidade;
                            double novoPreco;

                            switch (opcaoAlteracao) {
                                case "1":
                                    System.out.println("Digite o novo nome do produto a ser atualizado:");
                                    System.out.println("================================================================");
                                    novoNome = teclado.nextLine();
                                    if (novoNome.trim().isEmpty()) {
                                        System.out.println("Nome inválido, tente novamente!");
                                        break;
                                    }
                                    produtoParaAtualizar.nomeProduto = novoNome;
                                    break;

                                case "2":
                                    System.out.println("Digite a nova categoria do produto:");
                                    System.out.println("================================================================");
                                    novaCategoria = teclado.nextLine();
                                    if (novaCategoria.trim().isEmpty()) {
                                        System.out.println("Categoria inválida, tente novamente!");
                                        break;
                                    }
                                    produtoParaAtualizar.categoria = novaCategoria;
                                    break;

                                case "3":
                                    System.out.println("Digite a quantidade em número do produto disponível em estoque:");
                                    System.out.println("================================================================");
                                    novaQuantidade = teclado.nextFloat();
                                    if (novaQuantidade < 0) {
                                        System.out.println("Quantidade inválida, tente novamente!");
                                        break;
                                    }
                                    produtoParaAtualizar.quantidadeEstoque = novaQuantidade;
                                    teclado.nextLine(); // limpar buffer
                                    break;

                                case "4":
                                    System.out.println("Digite o novo preço unitário do produto:");
                                    System.out.println("================================================================");
                                    System.out.printf("R$ ");
                                    novoPreco = teclado.nextDouble();
                                    if (novoPreco <= 0) {
                                        System.out.println("Preço inválido, tente novamente!");
                                        break;
                                    }
                                    produtoParaAtualizar.preco = novoPreco;
                                    teclado.nextLine(); // limpar buffer
                                    break;

                                case "5":
                                    atualizar = false;
                                    System.out.println("Atualização cancelada!");
                                    break;

                                default:
                                    System.out.println("Opção inválida! Tente novamente.");
                                    continue;

                            }

                            if (opcaoAlteracao.equals("1") || opcaoAlteracao.equals("2") || opcaoAlteracao.equals("3") || opcaoAlteracao.equals("4")) {
                                System.out.println("================================================================");
                                System.out.println("           Confirmação de alteração do cadastro:");
                                System.out.println("================================================================");
                                System.out.println("Id: " + produtoParaAtualizar.id);
                                System.out.println("Nome do Produto: " + produtoParaAtualizar.nomeProduto);
                                System.out.println("Categoria: " + produtoParaAtualizar.categoria);
                                System.out.println("Quantidade em estoque: " + produtoParaAtualizar.quantidadeEstoque);
                                System.out.println("Preço unitário: R$" + produtoParaAtualizar.preco);
                                System.out.println("================================================================");

                                System.out.println("Você confirma os dados atualizados do produto? S/N");
                                System.out.println("================================================================");
                                String prodAtualizado;
                                prodAtualizado = teclado.nextLine().toUpperCase();

                                if (!prodAtualizado.equals("S")) {
                                    System.out.println("================================================================");
                                    System.out.println("      Produto não atualizado. Voltando ao menu inicial.");
                                    System.out.println("================================================================\n");
                                    break;

                                } else {
                                    System.out.println("================================================================");
                                    System.out.println("      Parabéns, seu produto foi atualizado com sucesso!");
                                    System.out.println("================================================================\n");
                                    break;
                                }
                            }

                        }

                    } else if (avisoIdNaoEncontrado) {
                        System.out.println("================================================================");
                        System.out.println(" Não foi encontrado produto com ID correspondente ao desejado.");
                        System.out.println("================================================================");
                    }
                    break;

                case "4":
                    String idExclusao;
                    for (FichaCadastral obj : cadastrosList) {
                        System.out.println("================================================================");
                        System.out.println("Id: " + obj.id);
                        System.out.println("Nome do Produto: " + obj.nomeProduto);
                        System.out.println("================================================================");
                    }
                    System.out.println("Digite o número do id corresponde ao produto que deseja excluir:");
                    System.out.println("================================================================");
                    idExclusao = teclado.nextLine();

                    int posicao = -1;

                    try {
                        for (FichaCadastral obj : cadastrosList) {

                            if (obj.id == Integer.parseInt(idExclusao)) {
                                posicao = cadastrosList.indexOf(obj);

                                System.out.println("================================================================");
                                System.out.println("      Estes são os dados referentes ao produto selecionado:");
                                System.out.println("================================================================");
                                System.out.println("Id: " + obj.id);
                                System.out.println("Nome do Produto: " + obj.nomeProduto);
                                System.out.println("Categoria: " + obj.categoria);
                                System.out.println("Quantidade em estoque: " + obj.quantidadeEstoque);
                                System.out.println("Preço unitário: R$" + obj.preco);
                                System.out.println("================================================================");
                                avisoIdNaoEncontrado = false;
                                break;
                            }
                        }
                        if (posicao == -1) {
                            System.out.println("Id não encontrado! Nenhum produto foi excluído.");
                            break;
                        }
                        String prodExcluido;
                        System.out.println("Você tem certeza que deseja excluir o produto selecionado? S/N");
                        System.out.println("================================================================");
                        prodExcluido = teclado.nextLine().toUpperCase();

                        if (!prodExcluido.equals("S")) {
                            System.out.println("================================================================");
                            System.out.println("      Produto não excluído. Voltando ao menu inicial.");
                            System.out.println("================================================================\n");
                            break;

                        } else {
                            cadastrosList.remove(posicao);
                            System.out.println(
                                    "================================================================");
                            System.out.println("      Parabéns, seu produto foi excluído com sucesso!");
                            System.out.println(
                                    "================================================================\n");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Favor inserir um número válido para o id.");
                    }
                    break;
                case "5":
                    boolean continuarBusca = true;

                    while (continuarBusca) {
                        String escolhaBusca;

                        System.out.println("Qual tipo de busca deseja realizar?");
                        System.out.println("================================================================\n");
                        System.out.println("1 - Busca por ID do produto");
                        System.out.println("2 - Busca por nome ou parte do nome do produto");
                        System.out.println("================================================================\n");
                        escolhaBusca = teclado.nextLine();

                        boolean produtoEncontrado = false;
                        switch (escolhaBusca) {
                            case "1":
                                int idBusca;
                                System.out.println("Digite o ID do produto:");
                                idBusca = teclado.nextInt();
                                teclado.nextLine(); // Limpa o buffer
                                for (FichaCadastral obj : cadastrosList) {
                                    if (obj.id == idBusca) {
                                        System.out.println("================================================================");
                                        System.out.println("      Estes são os dados referentes ao produto selecionado:");
                                        System.out.println("================================================================");
                                        System.out.println("Id: " + obj.id);
                                        System.out.println("Nome do Produto: " + obj.nomeProduto);
                                        System.out.println("Categoria: " + obj.categoria);
                                        System.out.println("Quantidade em estoque: " + obj.quantidadeEstoque);
                                        System.out.println("Preço unitário: R$" + obj.preco);
                                        System.out.println("================================================================");
                                        produtoEncontrado = true;
                                        break;
                                    }
                                }
                                break;

                            case "2":
                                String parteNome;
                                System.out.println("Digite parte do nome do produto:");
                                parteNome = teclado.nextLine().toLowerCase();
                                for (FichaCadastral obj : cadastrosList) {
                                    if (obj.nomeProduto.toLowerCase().contains(parteNome)) {
                                        System.out.println("================================================================");
                                        System.out.println("      Estes são os dados referentes ao produto selecionado:");
                                        System.out.println("================================================================");
                                        System.out.println("Id: " + obj.id);
                                        System.out.println("Nome do Produto: " + obj.nomeProduto);
                                        System.out.println("Categoria: " + obj.categoria);
                                        System.out.println("Quantidade em estoque: " + obj.quantidadeEstoque);
                                        System.out.println("Preço unitário: R$" + obj.preco);
                                        System.out.println("================================================================");
                                        produtoEncontrado = true;

                                    }
                                }
                                break;

                            default:
                                System.out.println("Opção inválida.");
                        }

                        if (!produtoEncontrado) {
                            System.out.println("Nenhum produto encontrado com os critérios informados.");
                        }

                        String resp;
                        System.out.println("Deseja realizar outra busca? (S/N)");
                        System.out.println("================================================================");
                        resp = teclado.nextLine().toUpperCase();
                        if (resp.equals("N")) {
                            continuarBusca = false;
                        }
                    }
                    break;

                case "0":
                    System.out.println("====================================================================");
                    System.out.println("Encerrando aplicativo 'Boutique Arcanum Lux - Exclusividade e Legado!', agradecemos pela preferência!");
                    System.out.println("====================================================================");
                    System.exit(0); // Encerra o programa
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (!escolha.equals("0"));

        teclado.close();
    }
}
