SAS Grid and Web Tier:
 - SAS Compute tier – multiple x86 Racks boxes
 - SAS 9.2 SP3 running on Linux Redhat 5.5 on HP BL 460s (x86 – 64 bit)
 - Web application server
 - Choice 1: 6.1.0.21 + WS 64 bit -minor releases on Linux – running as Cluster
 - IIS front ended at RBS (for CWS integration and static content) with HTTPS
 - Compute server (SAS) will be Grid enabled/load balanced over multiple boxes for horizontal scalability and failover and Grid enablement.
 - Fail-over via EGO with Grid s/w and Big IP.
 - Tivoli for monitoring
 - Extensive logging with 9.2 framework.
 - Connected to shared file system SAN (flat file area, temporary analytics storage etc, metadata) – Veritas CFS selected.
 - Storage of data is in SPDS and Teradata, except OLAP
 - includes data load vehicle for Teradata/Oracle/other DB’s
 - User and security management (integrates with core web security)
 - Delivers capabilities in:
 - A set of role based interfaces for users and managing this layer.
 
SAS (previously "Statistical Analysis System") is a software suite developed by SAS Institute for advanced analytics, multivariate analyses, business intelligence, data management, and predictive analytics.

