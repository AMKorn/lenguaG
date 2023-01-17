	extern printf
	extern scanf
	section .text
	global main
main:
	mov rbp,rsp
	push rbp

	; 	t3[0] = 1
	mov rax,t3
	add rax,0
	mov ebx,1
	mov [rax],ebx
	; 	t3[4] = 2
	mov rax,t3
	add rax,4
	mov ebx,2
	mov [rax],ebx
	; e0: skip
e0:
	; 	pmb main
	; 	in: t0
	mov rsi,t0
	mov rdi,fmtInInt
	mov al, 0
	call scanf
	; 	in: t1
	mov rsi,t1
	mov rdi,fmtInInt
	mov al, 0
	call scanf
	; 	t4 = t0 + t1
	mov eax,[t0]
	mov ebx,[t1]
	add ebx,eax
	mov [rsp+-4],ebx
	; 	t2 = t4
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
	section .data
t1:	dd 0
t0:	dd 0
t3:	dd 0
t2:	dd 0
fmtOutInt: db "%d",10,0
fmtOutChar: db "%s",10,0
fmtInInt:  db "%d", 0
fmtInChar:  db "%s", 0
