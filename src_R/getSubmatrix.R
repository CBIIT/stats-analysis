
########################
# File: getSubmatrix.R
# Author: Huaitian Liu
# Date: September 2005
########################

# Generate submatrix based on sample IDs
getSubmatrix <- function(datmat, grp1ids, grp2ids) {
    Submatrix <- cbind(datmat[,allid%in%grp1ids],datmat[,allid%in%grp2ids])
    return(Submatrix)
}

Submatrix <- getSubmatrix(datmat, grp1ids, grp2ids)  
  
# Generate submatrix based on reporters
getSubmatrix.rep <- function(datmat, rep.ids) {
    datmat.rep <- datmat[allrep.ids%in%rep.ids,]
    return(datmat.rep)
}

datmat.rep <- getSubmatrix.rep(datmat, rep.ids)  
