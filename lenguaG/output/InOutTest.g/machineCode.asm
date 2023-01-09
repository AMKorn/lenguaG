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
	mov eax,t3
	add eax,0
	mov ebx,1
	mov [eax],ebx
	; 	t3[4] = 2
	mov eax,t3
	add eax,4
	mov ebx,2
	mov [eax],ebx
	; 	t4[0] = 73
	mov eax,t4
	add eax,0
	mov ebx,73
	mov [eax],ebx
	; 	t4[1] = 110
	mov eax,t4
	add eax,1
	mov ebx,110
	mov [eax],ebx
	; 	t4[2] = 116
	mov eax,t4
	add eax,2
	mov ebx,116
	mov [eax],ebx
	; 	t4[3] = 114
	mov eax,t4
	add eax,3
	mov ebx,114
	mov [eax],ebx
	; 	t4[4] = 111
	mov eax,t4
	add eax,4
	mov ebx,111
	mov [eax],ebx
	; 	t4[5] = 100
	mov eax,t4
	add eax,5
	mov ebx,100
	mov [eax],ebx
	; 	t4[6] = 117
	mov eax,t4
	add eax,6
	mov ebx,117
	mov [eax],ebx
	; 	t4[7] = 99
	mov eax,t4
	add eax,7
	mov ebx,99
	mov [eax],ebx
	; 	t4[8] = 101
	mov eax,t4
	add eax,8
	mov ebx,101
	mov [eax],ebx
	; 	t4[9] = 32
	mov eax,t4
	add eax,9
	mov ebx,32
	mov [eax],ebx
	; 	t4[10] = 117
	mov eax,t4
	add eax,10
	mov ebx,117
	mov [eax],ebx
	; 	t4[11] = 110
	mov eax,t4
	add eax,11
	mov ebx,110
	mov [eax],ebx
	; 	t4[12] = 32
	mov eax,t4
	add eax,12
	mov ebx,32
	mov [eax],ebx
	; 	t4[13] = 110
	mov eax,t4
	add eax,13
	mov ebx,110
	mov [eax],ebx
	; 	t4[14] = 250
	mov eax,t4
	add eax,14
	mov ebx,250
	mov [eax],ebx
	; 	t4[15] = 109
	mov eax,t4
	add eax,15
	mov ebx,109
	mov [eax],ebx
	; 	t4[16] = 101
	mov eax,t4
	add eax,16
	mov ebx,101
	mov [eax],ebx
	; 	t4[17] = 114
	mov eax,t4
	add eax,17
	mov ebx,114
	mov [eax],ebx
	; 	t4[18] = 111
	mov eax,t4
	add eax,18
	mov ebx,111
	mov [eax],ebx
	; 	t4[19] = 58
	mov eax,t4
	add eax,19
	mov ebx,58
	mov [eax],ebx
        ;
        mov eax,t4
        add eax,20
        mov ebx,0
        mov [eax],ebx
	; e0: skip
e0:
	; 	pmb main
	; 	out: t4
	mov rdi,fmtOutChar
	mov rsi,[t4]
	mov rax, 0
	call printf
	; 	in: t0
	mov rsi,t0
	mov rdi,fmtInInt
	mov al, 0
	call scanf
	; 	out: t4
	mov rdi,fmtOutChar
	mov rsi,[t4]
	mov rax, 0
	call printf
	; 	in: t1
	mov rsi,t1
	mov rdi,fmtInInt
	mov al, 0
	call scanf
	; 	t5[0] = 69
	mov eax,[rsp]
	add eax,-20
	add eax,0
	mov ebx,69
	mov [eax],ebx
	; 	t5[1] = 108
	mov eax,[rsp]
	add eax,-20
	add eax,1
	mov ebx,108
	mov [eax],ebx
	; 	t5[2] = 32
	mov eax,[rsp]
	add eax,-20
	add eax,2
	mov ebx,32
	mov [eax],ebx
	; 	t5[3] = 114
	mov eax,[rsp]
	add eax,-20
	add eax,3
	mov ebx,114
	mov [eax],ebx
	; 	t5[4] = 101
	mov eax,[rsp]
	add eax,-20
	add eax,4
	mov ebx,101
	mov [eax],ebx
	; 	t5[5] = 115
	mov eax,[rsp]
	add eax,-20
	add eax,5
	mov ebx,115
	mov [eax],ebx
	; 	t5[6] = 117
	mov eax,[rsp]
	add eax,-20
	add eax,6
	mov ebx,117
	mov [eax],ebx
	; 	t5[7] = 108
	mov eax,[rsp]
	add eax,-20
	add eax,7
	mov ebx,108
	mov [eax],ebx
	; 	t5[8] = 116
	mov eax,[rsp]
	add eax,-20
	add eax,8
	mov ebx,116
	mov [eax],ebx
	; 	t5[9] = 97
	mov eax,[rsp]
	add eax,-20
	add eax,9
	mov ebx,97
	mov [eax],ebx
	; 	t5[10] = 100
	mov eax,[rsp]
	add eax,-20
	add eax,10
	mov ebx,100
	mov [eax],ebx
	; 	t5[11] = 111
	mov eax,[rsp]
	add eax,-20
	add eax,11
	mov ebx,111
	mov [eax],ebx
	; 	t5[12] = 32
	mov eax,[rsp]
	add eax,-20
	add eax,12
	mov ebx,32
	mov [eax],ebx
	; 	t5[13] = 101
	mov eax,[rsp]
	add eax,-20
	add eax,13
	mov ebx,101
	mov [eax],ebx
	; 	t5[14] = 115
	mov eax,[rsp]
	add eax,-20
	add eax,14
	mov ebx,115
	mov [eax],ebx
	; 	t5[15] = 58
	mov eax,[rsp]
	add eax,-20
	add eax,15
	mov ebx,58
	mov [eax],ebx
	; 	out: t5
	mov rdi,fmtOutChar
	mov rsi,[rsp+-20]
	mov rax, 0
	call printf
	; 	t6 = t0 + t1
	mov eax,[t0]
	mov ebx,[t1]
	add ebx,eax
	mov [rsp+-4],ebx
	; 	t2 = t6
	mov eax,[rsp+-4]
	mov [t2],eax
	; 	out: t2
	mov rdi,fmtOutChar
	mov rsi,[t2]
	mov rax, 0
	call printf

	pop rbp
	mov rax,0
	ret
