package com.nt.repo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.nt.entity.Product;
import com.nt.repository.ProductRepository;

public class RepoTest {
	@Autowired
	private ProductRepository repoData;

	@Test
	public void findData() {

		Optional<Product> data = repoData.findById(3952);
		assertThat(data).isEqualTo(data);
	}

}
