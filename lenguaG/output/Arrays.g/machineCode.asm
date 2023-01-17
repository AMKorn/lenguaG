	extern printf
	section .text
	global main
main:
	mov rbp,rsp
	push rbp

	; 	t0[0] = 1
	mov rax,t0
	add rax,0
	mov ebx,1
	mov [rax],ebx
	; 	t0[4] = 2
	mov rax,t0
	add rax,4
	mov ebx,2
	mov [rax],ebx
	; 	t0[8] = 3
	mov rax,t0
	add rax,8
	mov ebx,3
	mov [rax],ebx
	; 	t0[12] = 4
	mov rax,t0
	add rax,12
	mov ebx,4
	mov [rax],ebx
	; e0: skip
e0:
	; 	pmb main
	; 	t1 = 0 * 4
	mov eax,0
	mov ecx,4
	mul ecx
	mov [rsp+-20],eax
	; 	t2 = 0
	mov eax,0
	mov [rsp+-16],eax
	; 	t3 = t1 + t2
	mov eax,[rsp+-20]
	mov ebx,[rsp+-16]
	add ebx,eax
	mov [rsp+-12],ebx
	; 	t4 = t3 * 4
	mov eax,[rsp+-12]
	mov ecx,4
	mul ecx
	mov [rsp+-8],eax
	; 	t5 = t0[t4]
	mov rax,t0
	add rax,[rsp+-8]
	mov eax,[rax]
	mov [rsp+-4],eax
	; 	out: t5
	mov rdi,fmtOutInt
	mov rsi,[rsp+-4]
	mov rax, 0
	call printf

	pop rbp
	mov rax,0
	ret
	section .data
t0:	dd 0
fmtOutInt: db "%d",10,0
fmtOutChar: db "%s",10,0
