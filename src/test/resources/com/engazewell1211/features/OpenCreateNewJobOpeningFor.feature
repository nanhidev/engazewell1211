
@feature_open_create_new_job_opening
Feature: OpenCreateNewJobOpeningFor

  Background: 
    Given the user is on the Job Opening screen

  @open-job-opening-form
  Scenario Outline: Open Create New Job Opening Form
    When the user locates the Add Job Opening button
    And the user clicks on the Add Job Opening button
    Then the Create New Job Opening form is displayed
    And the form contains fields for job title, description, requirements, and other relevant information
    And the form displays Save and Cancel buttons

  Examples:
    |   |
    |   |

  @verify_mandatory_fields
  Scenario Outline: Open Create New Job Opening Form
    When the admin clicks on the Add Job Opening button to open the form
    Then the form should display all mandatory fields required for job creation
    And the form should include mandatory fields such as <mandatory_field_1>, <mandatory_field_2>, and <mandatory_field_3>
    And each mandatory field should be clearly marked

    Examples:
      | mandatory_field_1 | mandatory_field_2 | mandatory_field_3 |
      | Job Title         | Job Description    | Job Requirements    |

  @valid-job-opening
  Scenario Outline: Open Create New Job Opening Form
    When the user clicks on the Add Job Opening button to open the form
    And the user fills in the Job Title with <job_title>
    And the user fills in the Job Description with <job_description>
    And the user fills in the Job Requirements with <job_requirements>
    And the user clicks on the Save button
    Then the job opening is saved successfully
    And the user is redirected to the Job Opening screen
    And a success message is displayed confirming the job opening has been created

    Examples:
      | job_title                     | job_description                                         | job_requirements                                                                                     |
      | Software Engineer             | Develop and maintain software applications.            | Bachelor's degree in Computer Science or related field, 3+ years of experience in software development. |

@cancel_button_functionality
Scenario Outline: Open Create New Job Opening Form
  When the user clicks on the Add Job Opening button
  And the user enters <job_title> in the Job Title field
  And the user enters <job_description> in the Job Description field
  And the user clicks on the Cancel button
  Then the Create New Job Opening form should be closed
  And the user should be returned to the Job Opening screen without any data being saved

Examples:
  | job_title            | job_description                                 |
  | Software Engineer     | Develop and maintain software applications.     |

@validate_form_reset
Scenario Outline: Open Create New Job Opening Form
  When the user clicks on the Add Job Opening button to open the form
  And the user fills in the Job Title and Job Description fields
  And the user clicks on the Add Job Opening button again
  Then the Create New Job Opening form is displayed again
  And all fields are reset to their default state

Examples:
  | Job Title       | Job Description       |
  | <job_title>     | <job_description>     |

@screen_reader_accessibility
Scenario Outline: Open Create New Job Opening Form
  When the user clicks on the Add Job Opening button to open the form
  And the user uses a screen reader to navigate through the form fields
  Then all form fields should be announced correctly by the screen reader
  And the labels for each field should be clear and descriptive

Examples:
  | username | password |
  |          |          |

  @navigate_job_opening_form
  Scenario Outline: Open Create New Job Opening Form
    When the user clicks on the Add Job Opening button to open the form
    And the user uses the Tab key to navigate through the form fields
    And the user uses the Enter key to select the Save button
    Then the user should be able to navigate through all fields using the Tab key
    And the Save button should be activated using the Enter key

  Examples:
    | action                       |
    | Click on the Add Job Opening button to open the form |
    | Use the Tab key to navigate through the form fields   |
    | Use the Enter key to select the Save button           |

@valid-job-opening
Scenario Outline: Open Create New Job Opening Form
  When the user clicks on the Add Job Opening button to open the form
  And the user fills in valid data in all fields
    | Job Title                | Job Description                              | Job Requirements                                  |
    | <job_title>             | <job_description>                           | <job_requirements>                                |
  And the user clicks on the Save button
  Then the job opening is saved successfully
  And the user is redirected to the Job Opening screen
  And a success message is displayed confirming the job opening has been created

Examples:
  | job_title            | job_description                              | job_requirements                                  |
  | Software Engineer     | Develop and maintain software applications. | Bachelor's degree in Computer Science, 3+ years of experience. |

  @create-job-opening
  Scenario Outline: Open Create New Job Opening Form
    When the user clicks on the Add Job Opening button to open the form
    And the user fills in valid data in all mandatory fields and some optional fields
    And the user clicks on the Save button
    Then the job opening is saved successfully
    And the user is redirected to the Job Opening screen
    And a success message is displayed confirming the job opening has been created

  Examples:
    |  |
    |  |

  @valid-job-opening
  Scenario Outline: Open Create New Job Opening Form
    When the user clicks on the Add Job Opening button to open the form
    And the user fills in valid data in all mandatory fields and all optional fields
    And the user clicks on the Save button
    Then the job opening is saved successfully
    And the user is redirected to the Job Opening screen
    And a success message is displayed confirming the job opening has been created

  Examples:
    |  |
    |  |

  @valid-job-opening
  Scenario Outline: Open Create New Job Opening Form
    When the user clicks on the Add Job Opening button to open the form
    And the user fills in valid data in all mandatory fields and leaves optional fields empty
    And the user clicks on the Save button
    Then the job opening is saved successfully
    And the user is redirected to the Job Opening screen
    And a success message is displayed confirming the job opening has been created

  Examples:
    |  |
    |  |
