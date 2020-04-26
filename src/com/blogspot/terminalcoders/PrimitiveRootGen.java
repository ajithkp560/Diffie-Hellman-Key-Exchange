package com.blogspot.terminalcoders;
// (c) Coded By AJITH K P [ @ajithkp560 ]
// Diffie - Hellman Key Exchange Algorithm implementation in Java [TM] [Swing GUI]
// Blog: http://www.terminalcoders.blogspot.com
// ASE @ TCS Ltd.
import java.math.BigInteger;
import java.util.Random;
import java.util.Vector;

public class PrimitiveRootGen {
    long pr, p, phi;
    public PrimitiveRootGen(long p){
        this.p = p;
        this.phi = this.p - 1;
        Vector<Long> primitiveRoots =  this.getPrimitiveRoot(this.p, this.phi);
        this.pr = primitiveRoots.get(new Random().nextInt(primitiveRoots.size()));
    }

    public long getPr() {
        return pr;
    }

    private Vector<Long> getPrimitiveRoot(long p, long phi){
        Vector<Long> primeFactors = this.genPrimesFactorsList(phi);
        Vector<Long> primitiveRoots = new Vector<>();
        for(long i = 2;i<p;i++){
            boolean flg = false;
            for(Long l: primeFactors){
                BigInteger iBig = BigInteger.valueOf(i);
                BigInteger phiBig = BigInteger.valueOf(phi/l);
                BigInteger pBig = BigInteger.valueOf(p);
                BigInteger pRootBig = iBig.modPow(phiBig, pBig);
                if(pRootBig.compareTo(BigInteger.valueOf(1))==0){
                    flg = true;
                    break;
                }
            }
            if(!flg)primitiveRoots.add(i);
        }
        return primitiveRoots;
    }

    private Vector<Long> genPrimesFactorsList(long phi){
        Vector<Long> primesFactors = new Vector<>();
        while(phi % 2 == 0){
            primesFactors.add((long) 2);
            phi /= 2;
        }
        for(long i=3;i<=Math.sqrt(phi);i+=2){
            if(phi % i == 0){
                primesFactors.add(i);
                phi /= i;
            }
        }
        if(phi > 2){
            primesFactors.add(phi);
        }
        return primesFactors;
    }
}
