#include <iostream>
#include "carro.hpp"

using namespace std;

int main(){
    Carro meu_carro;
    Carro *carro2; //criou objeto com ponteiro, o objeto só é realmente criado
                  // quando o ponteiro é chamado.

    carro2 = new Carro(); // chamada do construtor criar objeto a partir de ponteiro
                            //o destrutor de ponteiro deve ser feito na mao
    carro2->setCapacidade(10);
    meu_carro.setCapacidade(5);
    cout << "Capacidade do carro " << meu_carro.capacidade<< endl;
    cout << "Capacidade do carro2 " << carro2->getCapacidade()<< endl;
    //chamada do destrutor
    delete carro2;
 return 0;
}
