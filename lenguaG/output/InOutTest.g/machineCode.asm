	extern printf
	extern scanf
	section .data
t1: 	times 4 db 0
t0: 	times 4 db 0
t4: 	times 20 db 0
t3: 	times 8 db 0
t2: 	times 4 db 0
fmtOutInt: db "%d",10,0
fmtOutChar: db "%s",10,0
fmtInInt:  db "%d", 0
fmtInChar:  db "%s", 0
	section .text
	global main
main:
	mov rbp, rsp
	push rbp

	; 	t3[0] = 1
	; 	t3[4] = 2
	; 	t4[0] = 73
	; 	t4[1] = 110
	; 	t4[2] = 116
	; 	t4[3] = 114
	; 	t4[4] = 111
	; 	t4[5] = 100
	; 	t4[6] = 117
	; 	t4[7] = 99
	; 	t4[8] = 101
	; 	t4[9] = 32
	; 	t4[10] = 117
	; 	t4[11] = 110
	; 	t4[12] = 32
	; 	t4[13] = 110
	; 	t4[14] = 250
	; 	t4[15] = 109
	; 	t4[16] = 101
	; 	t4[17] = 114
	; 	t4[18] = 111
	; 	t4[19] = 58
	; e0: skip
e0:
	; 	pmb main
	; 	out: t4
	mov rdi,fmtOutInt
	mov rsi,[t4]
	mov rax, 0
	call printf
	; 	in: t0
	mov rsi,t0
	mov rdi,fmtInInt
	mov al, 0
	call scanf
	; 	out: t4
	mov rdi,fmtOutInt
	mov rsi,[t4]
	mov rax, 0
	call printf
	; 	in: t1
	mov rsi,t1
	mov rdi,fmtInInt
	mov al, 0
	call scanf
	; 	t5[0] = 69
	; //t5 -> rsp+-20
	; 	t5[1] = 108
	; //t5 -> rsp+-20
	; 	t5[2] = 32
	; //t5 -> rsp+-20
	; 	t5[3] = 114
	; //t5 -> rsp+-20
	; 	t5[4] = 101
	; //t5 -> rsp+-20
	; 	t5[5] = 115
	; //t5 -> rsp+-20
	; 	t5[6] = 117
	; //t5 -> rsp+-20
	; 	t5[7] = 108
	; //t5 -> rsp+-20
	; 	t5[8] = 116
	; //t5 -> rsp+-20
	; 	t5[9] = 97
	; //t5 -> rsp+-20
	; 	t5[10] = 100
	; //t5 -> rsp+-20
	; 	t5[11] = 111
	; //t5 -> rsp+-20
	; 	t5[12] = 32
	; //t5 -> rsp+-20
	; 	t5[13] = 101
	; //t5 -> rsp+-20
	; 	t5[14] = 115
	; //t5 -> rsp+-20
	; 	t5[15] = 58
	; //t5 -> rsp+-20
	; 	out: t5
	; //t5 -> rsp+-20
	mov rdi,fmtOutInt
	mov rsi,[rsp+-20]
	mov rax, 0
	call printf
	; 	t6 = t0 + t1
	; //t6 -> rsp+-4
	mov eax,[t0]
	mov ebx,[t1]
	add ebx,eax
	mov [rsp+-4],ebx
	; 	t2 = t6
	; //t6 -> rsp+-4
	mov eax,[rsp+-4]
	mov [t2],eax
	; 	out: t2
	mov rdi,fmtOutInt
	mov rsi,[t2]
	mov rax, 0
	call printf

	pop rbp
	mov rax,0
	ret
