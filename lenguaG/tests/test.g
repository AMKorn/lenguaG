int foo(){
    int a = 1;
    int b = 2;
    if(a<b){
        return 1;
    } else if(a>b) {
        int c = a+b;
        return c;
    }
    int c = a+b;
    return 0;
}

void bar(){
    int a = 0;
}

main {
    // bar();
    for(int i = 0; i < 10; i = i+1){
        out(i);
    }
    //int a = foo();
}