###########################################################################################
# File: HC_genes.R
# Description: R module for higher order analysis tools - hierarchical clustering
# Author: Huaitian Liu
# Date: August 2005
###########################################################################################

# Clustering over reporters
mygenecluster <- function(x, diss=c("Correlation", "Euclidean"), meth=c("average","single","complete"), filename) {
    library(cluster)

    png(filename="genecluster%d.png")
    if (diss=='Correlation') 
    genclst <- hclust(as.dist(1-cor(t(x),use="pair")), method=meth) 
    plot(genclst,  xlab="", ylab="", cex=.5, sub="", hang=-1)
    mtext(paste("1-correlation",meth), side=2,line=3,cex=.8)
    #title("Clustering over the reporters", font=1,cex=0.5)
    
    if (diss=='Euclidean') {
    genclst<- hclust(dist(t(t(x))),method=meth)
    plot(genclst,  xlab="", ylab="", cex=.5, sub="", hang=-1)
    mtext(paste("Euclidean",meth), side=2,line=3,cex=.8)
    #title("Clustering over the reporters", font=1,cex=0.5)
    } 
    dev.off()
}
