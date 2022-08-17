package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(BankAccountNotFound.class)
	ResponseEntity<MyErrorDetails> bankNotFoundHandler(BankAccountNotFound bnf, WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setDateTime(LocalDateTime.now());
		err.setMessage(bnf.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(InsuficientBalance.class)
	ResponseEntity<MyErrorDetails> insuficientBalanceFound(InsuficientBalance nfe, WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setDateTime(LocalDateTime.now());
		err.setMessage(nfe.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(WalletNotFound.class)
	ResponseEntity<MyErrorDetails> walletNotFound(WalletNotFound nfe, WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setDateTime(LocalDateTime.now());
		err.setMessage(nfe.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BeneficiaryException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(BeneficiaryException ie, WebRequest wr)  {
		System.out.println("inside myHandler method...");
		
		MyErrorDetails err= new MyErrorDetails();
		err.setDateTime(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(wr.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST );

	}
	@ExceptionHandler(DateFormatException.class)
	ResponseEntity<MyErrorDetails> DateFormatException(DateFormatException dte, WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setDateTime(LocalDateTime.now());
		err.setMessage(dte.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(BankAccountAlreadyExist.class)
	ResponseEntity<MyErrorDetails> BankAccountAlreadyExist(BankAccountAlreadyExist be, WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setDateTime(LocalDateTime.now());
		err.setMessage(be.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BillPaymentNotFoundException.class)
	ResponseEntity<MyErrorDetails> BillPaymentNotFoundException(BillPaymentNotFoundException bpe, WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setDateTime(LocalDateTime.now());
		err.setMessage(bpe.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(InvalidAccountException.class)
	ResponseEntity<MyErrorDetails> InvalidAccountException(InvalidAccountException ive, WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setDateTime(LocalDateTime.now());
		err.setMessage(ive.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(InvalidDetailsException.class)
	ResponseEntity<MyErrorDetails> InvalidDetailsException(InvalidDetailsException ide, WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setDateTime(LocalDateTime.now());
		err.setMessage(ide.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TransactionNotFoundException.class)
	ResponseEntity<MyErrorDetails> TransactionNotFoundException(TransactionNotFoundException te, WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setDateTime(LocalDateTime.now());
		err.setMessage(te.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler(UserNotFoundException.class)
	ResponseEntity<MyErrorDetails> UserNotFoundException(UserNotFoundException ue, WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setDateTime(LocalDateTime.now());
		err.setMessage(ue.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	ResponseEntity<MyErrorDetails> noHandlerFound(NoHandlerFoundException nfe, WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setDateTime(LocalDateTime.now());
		err.setMessage(nfe.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	@ExceptionHandler(Exception.class)
	ResponseEntity<MyErrorDetails> exceptionHandler(Exception ie, WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setDateTime(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
}
