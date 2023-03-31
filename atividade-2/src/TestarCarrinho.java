import java.sql.SQLOutput;
import java.util.Scanner;

public class TestarCarrinho {
    public static void main(String[] args) {

        Scanner scTxt = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);
        Scanner scDo = new Scanner(System.in);

        Carrinho carrinho = new Carrinho();

        Integer menu = 0;


        while ( menu != 6){
            System.out.println("Escolha uma opção" +
                    "\n 1- Adicionar livro" +
                    "\n 2- Adicionar DVD" +
                    "\n 3- Adicionar Serviço" +
                    "\n 4- Exibir itens do carrinho" +
                    "\n 5- Exibir total de vendas" +
                    "\n 6- Fim");
            menu = scInt.nextInt();

            switch(menu) {
                case 1:
                    System.out.println("Adicionando um novo livro!!");

                    System.out.println("Entre com o codigo do livro!!");
                    Integer idLivro = scInt.nextInt();

                    System.out.println("Entre com o valor do livro!!");
                    Double precoLivro = scDo.nextDouble();

                    System.out.println("Entre com o nome do livro!!");
                    String escritoLivro = scTxt.nextLine();

                    System.out.println("Entre com nome do autor do Livro!!");
                    String escritoLivro2 = scTxt.nextLine();

                    System.out.println("Entre com op ISBM do Livro!!");
                    String escritoLivro3 = scTxt.nextLine();

                    Livro l = new Livro(idLivro, precoLivro, escritoLivro, escritoLivro2, escritoLivro3);
                carrinho.adicionarVendavel(l);

                    System.out.println("Livro adiconado! \n");

                    break;

                case 2:
                    System.out.println("Adicionando um novo DVD!!");

                    System.out.println("Entre com o codigo do DVD!!");
                    Integer idDVD = scInt.nextInt();

                    System.out.println("Entre com o valor do DVD!!");
                    Double precoDVD = scDo.nextDouble();

                    System.out.println("Entre com o nome do DVD!!");
                    String escritoDVD = scTxt.nextLine();

                    System.out.println("Entre com o nome da gravadora do DVD!!");
                    String escritoDVD2 = scTxt.nextLine();

                    DVD d = new DVD(idDVD, precoDVD, escritoDVD, escritoDVD2);


                    carrinho.adicionarVendavel(d);

                    System.out.println("DVD adiconado!! \n");


                    break;

                case 3:

                    System.out.println("Entre com o nome do serviço!!");
                    String escritoServiço = scTxt.nextLine();

                    System.out.println("Entre com o codigo do serviço!!");
                    Integer codigoServ = scInt.nextInt();

                    System.out.println("Entre com as horas trabalhadas!!");
                    Integer horasTrabalhadas = scInt.nextInt();

                    System.out.println("Entre com o valor das horas trabalhadas!!");
                    Double vlHora = scDo.nextDouble();


                    Servico s = new Servico(escritoServiço,codigoServ, horasTrabalhadas, vlHora);
                carrinho.adicionarVendavel(s);

                    System.out.println("Serviço adicionado!! \n");

                    break;

                case 4:
                    System.out.println("Exibindo itens do carrinho!!");

                    carrinho.exibeItensCarinnho();

                    break;

                case 5:

                    System.out.println("Exibindo total de vendas!!");

                    System.out.println(carrinho.calcularTotalVenda());

                    break;
            }
        }
        System.out.println("Obrigado por comprar!!");
    }
}
