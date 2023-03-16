# messingWithMod5
The question: if you pick any 3 unique numbers from 1 to 2000, what is the probability that the sum is divisible by 5?


To answer the question: it appears that it is exactly 20% of the time. (And this makes sense intuitively, because although you are summing it, so the distribution is more normalized, the chances are still 1-in-5. It is interesting that it is exact everytime though.)


The output for one of my runs (in case you cared) is as follows:

    Finished with 125 in 97 milliseconds
        false: 1,525,200 (0.800000)
        true:  381,300 (0.200000)

    Finished with 250 in 522 milliseconds (5.381443x)
        false: 12,350,400 (0.800000)
        true:  3,087,600 (0.200000)
    
    Finished with 500 in 3072 milliseconds (5.885057x)
        false: 99,400,800 (0.800000)
        true:  24,850,200 (0.200000)
    
    Finished with 1000 in 25058 milliseconds (8.156901x)
        false: 797,601,600 (0.800000)
        true:  199,400,400 (0.200000)
    
    Finished with 2000 in 195596 milliseconds (7.805731x)
        false: 6,390,403,200 (0.800000)
        true:  1,597,600,800 (0.200000)

As for the timing things, theoretically, it should be right at 8x. My guess is that because of kernel thread scheduling and stuff, the lower things can finish in less time overall because you don't have to hop away as much. And then there is a little bit of inevitable variability, and 7.8 and 8.2 are close enough to satisfy me. 