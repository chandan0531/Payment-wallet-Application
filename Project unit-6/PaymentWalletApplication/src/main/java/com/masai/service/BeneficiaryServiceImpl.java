package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.BeneficiaryDetails;
import com.masai.entities.Customer;
import com.masai.entities.Wallet;
import com.masai.exception.BeneficiaryException;
import com.masai.repository.BeneficiaryDao;
import com.masai.repository.WalletDao;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService{
	@Autowired
	private BeneficiaryDao bDao;
	
	@Autowired
	private WalletDao wDao;
	
	@Override
	public BeneficiaryDetails addBeneficiary(BeneficiaryDetails bd) {
		
		if(bDao.findById(bd.getMobileNumber()).isEmpty()) {
		
		Wallet w = bd.getWallet();
		
	         w.getBd().add(bd);
		
//	wDao.save(w);
		
		return bDao.save(bd);
		}else {
			throw new BeneficiaryException("Beneficiary already exists");
		}

	}

	@Override
	public BeneficiaryDetails viewBeneficiary(String mobNo) {
		Optional<BeneficiaryDetails> bdetails = bDao.findById(mobNo);
		if(bdetails.isPresent()) {
			return bdetails.get();
		}
		else {
			throw new BeneficiaryException("Beneficiary Not found ");
		}
	}

	@Override
	public List<BeneficiaryDetails> viewAllBeneficiary(Customer customer) {
		Integer id = customer.getWallet().getWalletId();
		
		Optional<Wallet> al = wDao.findById(id);
		
		Wallet w = al.get();
		
		return w.getBd();
		
	}

	@Override
	public BeneficiaryDetails deleteBeneficiary(BeneficiaryDetails bd) {
		
		Optional<BeneficiaryDetails> bdetails = bDao.findById(bd.getMobileNumber());
		
		if(bdetails.isPresent()) {
		BeneficiaryDetails b = bdetails.get();
		
		Wallet w = bd.getWallet();
		
		List<BeneficiaryDetails> blist = w.getBd();
		
		blist.remove(bd);
		
		bDao.delete(b);
		
//		wDao.save(w);
		
		return b;
		}
		else {
			throw new BeneficiaryException("No such Beneficiary present to delete");
		}
		
	}
	
}
