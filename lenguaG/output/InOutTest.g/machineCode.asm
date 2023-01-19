	extern printf
	extern scanf
	section .text
	global main
main:
	mov rbp,rsp
	push rbp

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
	; 	t3 = t0 + t1
	mov eax,[t0]
	mov ebx,[t1]
	add ebx,eax
	mov [rsp+-4],ebx
	; 	t2 = t3
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
t2:	dd 0
fmtOutInt: db "%d",10,0
fmtInInt:  db "%d", 0
