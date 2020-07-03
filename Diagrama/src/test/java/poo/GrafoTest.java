package poo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe responsável pelos testes de unidade
 * @author Renan Rodolfo da Silva
 */
public class GrafoTest {

    /**
     * valida as restrições mínimas e máximas  do nó End Point
     */
    @Test
    public void validarRestricoesEndPoint() {
        Grafo endpoint = new Grafo("Grafo_test");
        endpoint.addNode("EndPoint_Desktop",EnumNodeNames.desktop);     //no máximo a um outro nó//no máximo a um outro nó
        endpoint.addNode("EndPoint_server",EnumNodeNames.server);     //no máximo a um outro nó
        endpoint.addNode("EndPoint_Camera",EnumNodeNames.ipCamera);     //no máximo a um outro nó
        endpoint.addNode("Internet",EnumNodeNames.wan);        // 1 ou N outros nós

        endpoint.addNodeOrigemToDestino("desktop1","wan1");
        assertEquals("True, desktop possui 1 associações", true, endpoint.validarRestricoes());

        endpoint.addNodeOrigemToDestino("ipCamera1","wan1");
        assertEquals("True, ipCamera possui somente 1 associações", true, endpoint.validarRestricoes());

        endpoint.addNodeOrigemToDestino("server1","wan1");
        assertEquals("True, server possui somente 1 associações", true, endpoint.validarRestricoes());

        endpoint.addNodeOrigemToDestino("desktop1","wan1");
        assertEquals("False, desktop pode ter somente 1 associação", false, endpoint.validarRestricoes());

        endpoint.addNodeOrigemToDestino("server1","wan1");
        assertEquals("False, server pode ter somente 1 associação", false, endpoint.validarRestricoes());

        endpoint.addNodeOrigemToDestino("ipCamera1","wan1");
        assertEquals("False, ipCamera pode ter somente 1 associação", false, endpoint.validarRestricoes());

        endpoint.addNodeOrigemToDestino("tela","wan1");
        assertEquals("False, node de origem inválido", false, endpoint.validarRestricoes());

    }
    /**
     * valida as restrições mínimas e máximas  do nó Firewall
     */
    @Test
    public void validarRestricoesFirewall() {
        Grafo firewall = new Grafo("Grafo_test");
        firewall.addNode("EndPoint_Desktop",EnumNodeNames.desktop);     //no máximo a um outro nó
        firewall.addNode("Internet",EnumNodeNames.wan);        // 1 ou N outros nós
        firewall.addNode("Roteador",EnumNodeNames.router);     // 2 ou N outros nós
        firewall.addNode("Switch",EnumNodeNames.sw);           // 1 ou N outros nós
        firewall.addNode("Mikrotik",EnumNodeNames.firewall);   // 2 ou N outros nós

        firewall.addNodeOrigemToDestino("firewall1","wan1");
        assertEquals("False, firewall precisa ter 2 ou N associações", false, firewall.validarRestricoes());

        firewall.addNodeOrigemToDestino("firewall1","sw1");
        assertEquals("True, firewall possui 2 ou N associações", true, firewall.validarRestricoes());

        assertEquals("False, node destino inválido", false, firewall.addNodeOrigemToDestino("firewall1","batata","sw1"));

        firewall.addNodeOrigemToDestino("batata","sw1");
        assertEquals("True, node origem inválido, não foi inserido no grafo", true, firewall.validarRestricoes());

    }
    /**
     * valida as restrições mínimas e máximas  do nó Switch
     */
    @Test
    public void validarRestricoesSwitch() {
        Grafo sw = new Grafo("Grafo_test");
        sw.addNode("EndPoint_Desktop",EnumNodeNames.desktop);     //no máximo a um outro nó
        sw.addNode("Internet",EnumNodeNames.wan);        // 1 ou N outros nós
        sw.addNode("Roteador",EnumNodeNames.router);     // 2 ou N outros nós
        sw.addNode("Switch",EnumNodeNames.sw);           // 1 ou N outros nós
        sw.addNode("Mikrotik",EnumNodeNames.firewall);   // 2 ou N outros nós


        sw.addNodeOrigemToDestino("sw1","sw1");
        assertEquals("True, sw possui 1 ou N associações", true, sw.validarRestricoes());

        assertEquals("False, node destino inválido", false, sw.addNodeOrigemToDestino("sw1","batata","sw1"));

        sw.addNodeOrigemToDestino("batata","sw1");
        assertEquals("False, node origem inválido, não foi inserido no grafo", true, sw.validarRestricoes());

    }
    /**
     * valida as restrições mínimas e máximas  do nó Router
     */
    @Test
    public void validarRestricoesRouter() {
        Grafo router = new Grafo("Grafo_test");
        router.addNode("EndPoint_Desktop",EnumNodeNames.desktop);     //no máximo a um outro nó
        router.addNode("Internet",EnumNodeNames.wan);        // 1 ou N outros nós
        router.addNode("Roteador",EnumNodeNames.router);     // 2 ou N outros nós
        router.addNode("Switch",EnumNodeNames.sw);           // 1 ou N outros nós
        router.addNode("Mikrotik",EnumNodeNames.firewall);   // 2 ou N outros nós


        router.addNodeOrigemToDestino("router1","sw1");
        assertEquals("False, router precisa ter 2 ou N associações", false, router.validarRestricoes());

        assertEquals("True, router possui 2 ou N associações", true, router.addNodeOrigemToDestino("sw1","wan1","sw1"));

        router.addNodeOrigemToDestino("batata","router1");
        assertEquals("False, node origem inválido, não foi inserido no grafo", true, router.validarRestricoes());

        assertEquals("False, node destino inválido", false, router.addNodeOrigemToDestino("router1","batata","sw1"));





    }
    /**
     * valida as restrições mínimas e máximas  do nó Internet
     */
    @Test
    public void validarRestricoesInternet() {
        Grafo internet = new Grafo("Grafo_test");
        internet.addNode("EndPoint_Desktop",EnumNodeNames.desktop);     //no máximo a um outro nó
        internet.addNode("Internet",EnumNodeNames.wan);        // 1 ou N outros nós
        internet.addNode("Roteador",EnumNodeNames.router);     // 2 ou N outros nós
        internet.addNode("Switch",EnumNodeNames.sw);           // 1 ou N outros nós
        internet.addNode("Mikrotik",EnumNodeNames.firewall);   // 2 ou N outros nós

        internet.addNodeOrigemToDestino("wan1","sw1");
        assertEquals("True, wan possui 1 ou N associações", true, internet.validarRestricoes());

        assertEquals("False, node destino inválido", false, internet.addNodeOrigemToDestino("sw1","batata","sw1"));

        internet.addNodeOrigemToDestino("batata","sw1");
        assertEquals("False, node origem inválido, não foi inserido no grafo", true, internet.validarRestricoes());

    }
    /**
     * valida a quantidade máxima de restrição que os nós podem ter
     */
    @Test
    public void validarNAssociacoes() {
        Grafo testeN = new Grafo("Grafo_test");

        testeN.addNode("Internet",EnumNodeNames.wan);        // 1 ou N outros nós
        testeN.addNode("Switch",EnumNodeNames.sw);           // 1 ou N outros nós
        testeN.addNode("Switch",EnumNodeNames.sw);           // 1 ou N outros nós
        testeN.addNode("Switch",EnumNodeNames.sw);           // 1 ou N outros nós
        testeN.addNode("Switch",EnumNodeNames.sw);           // 1 ou N outros nós
        testeN.addNode("Switch",EnumNodeNames.sw);           // 1 ou N outros nós
        testeN.addNode("Switch",EnumNodeNames.sw);           // 1 ou N outros nós
        testeN.addNode("Switch",EnumNodeNames.sw);           // 1 ou N outros nós
        testeN.addNode("Switch",EnumNodeNames.sw);           // 1 ou N outros nós
        testeN.addNode("Switch",EnumNodeNames.sw);           // 1 ou N outros nós
        testeN.addNode("Switch",EnumNodeNames.sw);           // 1 ou N outros nós
        testeN.addNode("Mikrotik",EnumNodeNames.router);


        testeN.addNodeOrigemToDestino("router1","sw1","sw2","sw3","sw4","sw5","sw6","sw7","sw8","sw9","sw10","wan1");
        assertEquals("False, router possui mais de N associações", false,testeN.validarRestricoes());



    }


}

