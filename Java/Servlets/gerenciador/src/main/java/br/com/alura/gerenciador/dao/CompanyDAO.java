package br.com.alura.gerenciador.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.alura.gerenciador.Company;

public class CompanyDAO {

	private final static Map<Long, Company> COMPANIES = new HashMap<>();
	static {
		geraIdEAdiciona(new Company("Doceria Bela Vista"));
		geraIdEAdiciona(new Company("Ferragens Docel"));
		geraIdEAdiciona(new Company("Alura"));
		geraIdEAdiciona(new Company("Google"));
		geraIdEAdiciona(new Company("Caelum"));
		geraIdEAdiciona(new Company("Casa do Código"));
	}

	public Collection<Company> buscaPorSimilaridade(String name) {
		if (name == null)
			return COMPANIES.values();
		
		List<Company> similares = new ArrayList<>();
		for (Company empresa : COMPANIES.values()) {
			if (empresa.getName().toLowerCase().contains(name.toLowerCase()))
				similares.add(empresa);
		}
		return similares;
	}

	public void add(Company company) {
		geraIdEAdiciona(company);
	}

	private static void geraIdEAdiciona(Company company) {
		long id = COMPANIES.size()+1l;
		company.setId(id);
		COMPANIES.put(id, company);
	}
}
