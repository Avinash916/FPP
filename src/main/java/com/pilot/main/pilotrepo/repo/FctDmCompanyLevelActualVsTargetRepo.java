<<<<<<< HEAD
<<<<<<< HEAD
package com.pilot.main.pilotrepo.repo;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.pilot.main.pilotrepo.entity.FctDmCompanyLevelActualVsTargetEntity;

public interface FctDmCompanyLevelActualVsTargetRepo
		extends CrudRepository<FctDmCompanyLevelActualVsTargetEntity, Long>,
		QueryDslPredicateExecutor<FctDmCompanyLevelActualVsTargetEntity> {

=======
package com.pilot.main.pilotrepo.repo;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
=======
package com.pilot.main.pilotrepo.repo;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
import org.springframework.data.repository.CrudRepository;

import com.pilot.main.pilotrepo.entity.FctDmCompanyLevelActualVsTargetEntity;

public interface FctDmCompanyLevelActualVsTargetRepo
		extends CrudRepository<FctDmCompanyLevelActualVsTargetEntity, Long>,
<<<<<<< HEAD
		QuerydslPredicateExecutor<FctDmCompanyLevelActualVsTargetEntity> {

>>>>>>> ssointegration
=======
		QueryDslPredicateExecutor<FctDmCompanyLevelActualVsTargetEntity> {

>>>>>>> c23f1a2dac02f9465e3f80b3c9688dce9ef023f1
}