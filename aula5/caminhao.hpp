// AULA HERANÇA

#ifndef  CAMINHAO_H_ // se eu ainda não defini caminhao.hpp defina agora,
                    // caso esteja definido não defina este. ajuda a mudar o nome
#define CAMINHAO_H_
#include "carro.hpp"

//#include <iostream>
//#include <string>  
// como ta herdando de carro não precisa
class Caminhao : public Carro // Caminhao herda de carro
{
private:
    float carga;
    float altura;
    float comprimento;
    string tipoCarga;
public:
    Caminhao(); //construtor 
    ~Caminhao();
    void set_tipocarga(string tcarga );
    string get_tipoCarga();
};
#endif