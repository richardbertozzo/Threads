/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author Richard
 */
public class Buffer {

    private int indiceThread = 0;
    private int threadLeitor = 0;
    private boolean occupied = false;

    public synchronized void escrever(int msg) {
        String nomethread = Thread.currentThread().getName();
        while (occupied) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("A thread: " + nomethread + " foi parada na escrita");
            }
        }
        indiceThread = msg;
        occupied = true;
        System.out.println(nomethread + " - escreveu/enviou-" + indiceThread);
        notifyAll();
    }

    public synchronized int ler() {
        String nomethread = Thread.currentThread().getName();
        while (!occupied) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("A thread: " + nomethread + " foi parada na leitura");
            }
        }

        if (threadLeitor < 4) {
            threadLeitor++;
            System.out.println(nomethread + " - leu/recebeu-" + indiceThread);
        }
        if (threadLeitor == 4) {
            occupied = false;
            threadLeitor = 0;
            notify();
        }

        return indiceThread;
    }

}
