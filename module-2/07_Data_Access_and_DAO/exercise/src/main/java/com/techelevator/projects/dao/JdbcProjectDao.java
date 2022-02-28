package com.techelevator.projects.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.plaf.SliderUI;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(Long projectId) {
		Project project = null;

		String sql = "SELECT name, from_date, to_date" +
					 " FROM project" +
					 " WHERE project_id = ?";

		SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, projectId);

		if (results.next()) {
			project = new Project();
			String projectName = results.getString("name");
			Date startDate = results.getDate("from_date");
			Date endDate = results.getDate("to_date");

			if (projectId != null) {
				project.setId(projectId);
			}

			if (projectName != null) {
				project.setName(projectName);
			}

			if (startDate != null) {
				LocalDate fromDate = startDate.toLocalDate();
				project.setFromDate(fromDate);
			}

			if (endDate != null) {
				LocalDate toDate = endDate.toLocalDate();
				project.setToDate(toDate);
			}
		}

		return project;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<>();
		String sql = "SELECT project_id, name, from_date, to_date" +
				" FROM project;";
		SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Project project = mapRowToProject(results);
			projects.add(project);
		}

		return projects;
	}

	@Override
	public Project createProject(Project newProject) {
		String sql = "INSERT INTO project (name, from_date, to_date)" +
				" VALUES (?, ?, ?) RETURNING project_id;";
		Long projectId = this.jdbcTemplate.queryForObject(sql, Long.class,
				newProject.getName(),
				newProject.getFromDate(),
				newProject.getToDate()
				);

		return this.getProject(projectId);
	}

	@Override
	public void deleteProject(Long projectId) {
		String removeFromProjectEmployee = "DELETE FROM project_employee" +
				" WHERE project_id = ?;";

		String removeFromProject = "DELETE FROM project" +
				" WHERE project_id = ?;";

		this.jdbcTemplate.update(removeFromProjectEmployee, projectId);
		this.jdbcTemplate.update(removeFromProject, projectId);
	}

	private Project mapRowToProject(SqlRowSet rowSet) {
		Date startDate = rowSet.getDate("from_date");
		Date endDate = rowSet.getDate("to_date");

		Project project = new Project();
		project.setId(rowSet.getLong("project_id"));
		project.setName(rowSet.getString("name"));
		if (startDate != null) {
			project.setFromDate(rowSet.getDate("from_date").toLocalDate());
		}
		if (endDate != null) {
			project.setToDate(rowSet.getDate("to_date").toLocalDate());
		}
		return project;
	}
	

}
