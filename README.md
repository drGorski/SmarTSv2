# SmarTSv2
The package generates and runs a minimal set of test cases for two smart contract types: verifying a single transaction kind and checking multiple types of logically congruent transactions.

## The package structure

The package structure includes an abstraction layer that is a reusable component, which can be directly used in smart contract development projects.

The abstract layer of the SmarTSv2 package consists of the following classes:
* ``AbstractTransaction`` class --- an abstract class that represents the generic transaction.
* ``AbstractSC`` class --- an abstract class that defines the generic smart contract verifying a single transaction kind. The class declares a data structure for storing smart contract verification rules. The single verification rule is declared as a ``Predicate<AbstractTransaction>`` type. The implementation of the transaction verification mechanism was provided in the ``checkSC()`` method. The method was marked as final which prevents overriding.
* ``AbstractTestSC`` class --- an abstract test class for smart contracts that inspects a single transaction type. The ``initiateTransactions()`` method is abstract and must be implemented by a specific smart contract test class. The method should create transaction objects needed to execute a test suite for the smart contract.
* ``AbstractConfigSC`` class --- an abstract class of a smart contract that verifies multiple types of transactions. The class declares an instance variable ``configurations``, which is a list of verification rule configurations for various types of transactions.
* ``AbstractTestConfigSC`` class --- an abstract test class for smart contracts that validate multiple transaction types.

## Package classes in a UML class diagram

The figure below presents the UML Class diagram with abstract classes in the SmarTSv2 package.
<p align="center">
  <img src="UML Class diagram.png" alt="UML Class diagram" width="450">
</p>

## Running test suites

The ``RunTestSuite`` class should be run to execute predefined test suites for two example smart contracts. 
