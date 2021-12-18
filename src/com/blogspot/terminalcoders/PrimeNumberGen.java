package com.blogspot.terminalcoders;
// (c) Coded By AJITH K P [ @ajithkp560 ]
// Diffie - Hellman Key Exchange Algorithm implementation in Java [TM] [Swing GUI]
// Blog: http://www.terminalcoders.blogspot.com
// ASE @ TCS Ltd.
import java.util.Random;

public class PrimeNumberGen {
    private long n;
    public long getPrimeNumber(){
        this.n = (int)(new Random().nextDouble()*100)+250;
        long l = 0;
        // Refer paper :  https://www.emis.de/journals/JIS/VOL22/Axler/axler17.pdf
        l = (long) ((this.n)*(Math.log(this.n) + (Math.log(Math.log(this.n)) -1) + ((Math.log(Math.log(this.n))-2)/(Math.log(this.n))) - ((Math.log(Math.log(this.n)) -21.0/10.0)/Math.log(this.n)) ));
        for(long i=l;;i++){
            if(isPrime(i)){
                return i;
            }
        }
    }
    private boolean isPrime(long n){
        if(n%2 == 0 || n%3 == 0) return false;
        for(int i=5; i*i<=n; i+=6){
            if(n%i == 0 || n%(i+2)==0) return false;
        }
        return true;
    }
}
