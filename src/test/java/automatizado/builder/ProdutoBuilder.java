package automatizado.builder;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import automatizado.page.ProdutoPO;

public class ProdutoBuilder {
 
    public Random random = new Random(); 
    public Random r = new Random();

    public Integer codigoParcial = r.nextInt();
    public String codigo = codigoParcial.toString();
    
    public List<String> nomeParcial = Arrays.asList("A", "B", "C", "D", "E", "F", "Z");
    public String nome = nomeParcial.get(new Random().nextInt(nomeParcial.size()));

    public Integer quantidade = r.nextInt();
    public  Double valor = r.nextDouble();

    public Random random2 = new Random();
    public Integer minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
    public Integer maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
    long randomDay = minDay + random2.nextInt(maxDay - minDay);

    LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);

    public String data = randomBirthDate.toString();

    private ProdutoPO ProdutoPO;
    
    public ProdutoBuilder(ProdutoPO ProdutoPO){
        this.ProdutoPO = ProdutoPO;
    }

    public ProdutoBuilder adicionarCodigo (String codigo){
        this.codigo = codigo;
        return this;
    }

        public ProdutoBuilder adicionarNome (String nome){
        this.nome = nome;
        return this;
    }

    public ProdutoBuilder adicionarQuantidade (Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }

    public ProdutoBuilder adicionarValor (Double valor){
        this.valor = valor;
        return this;
    }
    
    public ProdutoBuilder adicionarData (String data){
        this.data = data;
        return this;
    }

    public void builder(){

        ProdutoPO.escrever(ProdutoPO.inputCodigo, codigo);
        ProdutoPO.escrever(ProdutoPO.inputNomeDoProduto, nome);
        ProdutoPO.escrever(ProdutoPO.inputQuantidadeDoProduto, quantidade.toString());
        ProdutoPO.escrever(ProdutoPO.inputValorDoProduto, valor.toString());
        ProdutoPO.escrever(ProdutoPO.inputDataDoProduto, data);
        ProdutoPO.botaoDeSalvarProdutoCriando.click();
       
    }
}
