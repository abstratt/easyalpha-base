package com.abstratt.easyalpha.core.domain;

import org.springframework.stereotype.Repository;

@Repository
interface ApplicationUserRepository : UserRepository<ApplicationUser> {
}