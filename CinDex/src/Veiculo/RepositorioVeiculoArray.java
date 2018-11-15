package Veiculo;

import erros.*;

public class RepositorioVeiculoArray implements RepositorioVeiculo{
    private Veiculo[] arrayVeiculos;
    private int count;

    public RepositorioVeiculoArray(){
        this.arrayVeiculos = new Veiculo[200];
        this.count = 0;
    }

    public void inserirVeiculo(Veiculo veiculo)
            throws VeiculoJaExistenteException, LimiteAtingidoException{
        boolean cheio = false;
        for(count = 0; count < arrayVeiculos.length; count++){
            if(arrayVeiculos[count] != null && arrayVeiculos[count].getNomeVeiculo().equals(veiculo.getNomeVeiculo())){
                VeiculoJaExistenteException e;
                e = new VeiculoJaExistenteException();
                throw e;
            }
            else if(arrayVeiculos[count] == null){
                this.arrayVeiculos[count] = veiculo;
            }
            if(count == arrayVeiculos.length -1){
                cheio = true;
            }
        }

        if(cheio){
            LimiteAtingidoException e;
            e = new LimiteAtingidoException();
            throw e;
        }
    }

    public void removerVeiculo(String nome)
            throws VeiculoNaoEncontradoException{
        boolean achou = false;
        for(count = 0; count < arrayVeiculos.length && !achou; count++){
            if(arrayVeiculos[count].getNomeVeiculo().equals(nome)){
                achou = true;
                for(int i = count; i < arrayVeiculos.length; i++){
                    arrayVeiculos[i] = arrayVeiculos[i + 1];
                }
                this.arrayVeiculos[arrayVeiculos.length - 1] = null;
            }
        }

        if(!achou){
            VeiculoNaoEncontradoException e;
            e = new VeiculoNaoEncontradoException();
            throw e;
        }
    }

    public void atualizarVeiculo(Veiculo veiculo)
            throws VeiculoNaoEncontradoException{
        boolean achou = false;
        for(count = 0; count < arrayVeiculos.length && !achou; count++){
            if(this.arrayVeiculos[count].getNomeVeiculo().equals(veiculo.getNomeVeiculo())){
                achou = true;
                this.arrayVeiculos[count] = veiculo;
            }
        }

        if(!achou){
            VeiculoNaoEncontradoException e;
            e = new VeiculoNaoEncontradoException();
            throw e;
        }
    }

    public boolean existeVeiculo(String nome){
        boolean existencia = false;
        for(count = 0; count < arrayVeiculos.length && !existencia; count++){
            if(this.arrayVeiculos[count].getNomeVeiculo().equals(nome)){
                existencia = true;
            }
        }

        return existencia;
    }

    public Veiculo procuraVeiculo(String nome)
            throws VeiculoNaoEncontradoException{

        boolean achou = false;
        Veiculo retorno = null;

        for(count = 0; count < arrayVeiculos.length && !achou; count++){
            if(this.arrayVeiculos[count].getNomeVeiculo().equals(nome)){
                achou = true;
                retorno = this.arrayVeiculos[count];
            }
        }

        if(achou){
            return retorno;
        }
        else{
            VeiculoNaoEncontradoException e;
            e = new VeiculoNaoEncontradoException();
            throw e;
        }
    }
}
