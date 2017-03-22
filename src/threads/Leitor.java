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
public class Leitor implements Runnable {

    private Buffer buffer;

    public Leitor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 120; i++) {
            while (buffer.ler() != 0) {
            }
        }
    }
}
