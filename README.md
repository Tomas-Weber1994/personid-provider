# Person ID Provider (Helper App for Genesis Resources)

## Overview

This is a **helper application** for the main project `genesis-resources`.  
It simulates an external certification authority API for person IDs, providing a static list of valid IDs for testing and development purposes.

---

## Purpose

In the real world, person IDs would be issued and validated by an external certification authority via an API.  
For simplicity, this mock service:

- Provides a static list of valid person IDs.
- Exposes an HTTP endpoint for the main application to verify user person IDs.

---

## API

### GET `/api/v1/person-id`

Returns all valid person IDs in JSON format:

```json
{
  "validPersonIds": [
    "jXa4g3H7oPq2",
    "yB9fR6tK0wLm",
    "cN1vZ8pE5sYx",
    "tQdG2kP3mJfB",
    "iM5sO6tXcW7v",
    "rU8nA9eT2bYh",
    ...
  ]
}
