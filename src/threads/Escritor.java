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
public class Escritor implements Runnable {

    private Buffer buffer;

    public Escritor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 120; i++) {
            buffer.escrever(i);
        }
    }

}
