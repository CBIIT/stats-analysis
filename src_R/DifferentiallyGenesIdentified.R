##############################################################################################################
# File: DifferentiallyGenesIdentified.R
# Author: Huaitian Liu
# Date: September 2005
###############################################################################################################

# Identify differentially expressed genes based on absolute fold change>=2 and pvalue<=0.001

mydiferentiallygenes.ParametricTest <- function(datmat, cons1=2, cons2=0.001) {
sel <- (result$fc >= cons1) & (result$pval <=cons2)
dif.exp.gene <- dimnames(datmat)[[1]][sel]
return(dif.exp.gene)
}

# Call function
# dif.exp.gene <- mydiferentiallygenes.ParametricTest(datmat,2,0.001)

###############################################################################################################
# Identify differentially expressed genes based on absolute fold change>=2 and adjustP<=0.1

mydiferentiallygenes.NonparametricTest <- function(datmat, cons1=2, cons2=0.1) {
sel <- (result$fc >= cons1) & (adjustP <=cons2)
dif.exp.gene <- dimnames(datmat)[[1]][sel]
return(dif.exp.gene)
}

# Call function
# dif.exp.gene <- mydiferentiallygenes.NonparametricTest(datmat,2,0.1)
